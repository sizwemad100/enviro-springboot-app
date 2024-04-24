package com.enviro.assessment.grad001.sizwemadlabane.enviro.service.Impl;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.WasteCategory;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Override
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste Category not found with id: " + id));
    }

    @Override
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);

    }

    @Override
    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedCategory) {
        WasteCategory existingCategory = getWasteCategoryById(id);
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        return wasteCategoryRepository.save(existingCategory);
    }

    @Override
    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }

}
