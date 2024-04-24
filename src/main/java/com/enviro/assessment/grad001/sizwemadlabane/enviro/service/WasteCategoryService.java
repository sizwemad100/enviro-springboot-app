package com.enviro.assessment.grad001.sizwemadlabane.enviro.service;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.WasteCategory;

import java.util.List;

public interface WasteCategoryService {

    public List<WasteCategory> getAllWasteCategories();

    public WasteCategory getWasteCategoryById(Long id);

    public WasteCategory createWasteCategory(WasteCategory wasteCategory);

    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedCategory);

    public void deleteWasteCategory(Long id);
}
