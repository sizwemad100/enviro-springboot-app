package com.enviro.assessment.grad001.sizwemadlabane.enviro.repository;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepository  extends JpaRepository<WasteCategory, Long> {
    // can create custom queries
}
