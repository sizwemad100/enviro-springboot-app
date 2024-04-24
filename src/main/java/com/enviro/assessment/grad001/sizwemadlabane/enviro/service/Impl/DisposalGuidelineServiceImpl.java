package com.enviro.assessment.grad001.sizwemadlabane.enviro.service.Impl;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineServiceImpl  implements DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Override
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    @Override
    public DisposalGuideline getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal Guideline not found with id: " + id));
    }

    @Override
    public DisposalGuideline createDisposalGuideline(DisposalGuideline disposalGuideline) {
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    @Override
    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = getDisposalGuidelineById(id);
        existingGuideline.setCategory(updatedGuideline.getCategory());
        existingGuideline.setGuideline(updatedGuideline.getGuideline());
        return disposalGuidelineRepository.save(existingGuideline);
    }

    @Override
    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
