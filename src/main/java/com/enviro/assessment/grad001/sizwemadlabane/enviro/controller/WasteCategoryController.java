package com.enviro.assessment.grad001.sizwemadlabane.enviro.controller;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.WasteCategory;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        return ResponseEntity.ok(wasteCategory);
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        WasteCategory createdCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory updatedCategory) {
        WasteCategory updated = wasteCategoryService.updateWasteCategory(id, updatedCategory);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
