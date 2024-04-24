package com.enviro.assessment.grad001.sizwemadlabane.enviro.service.Impl;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.RecyclingTip;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {
    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    @Override
    public RecyclingTip getRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recycling Tip not found with id: " + id));
    }

    @Override
    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    @Override
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip) {
        RecyclingTip existingTip = getRecyclingTipById(id);
        existingTip.setTip(updatedTip.getTip());
        return recyclingTipRepository.save(existingTip);
    }

    @Override
    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}
