package com.enviro.assessment.grad001.sizwemadlabane.enviro.service;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.RecyclingTip;

import java.util.List;

public interface RecyclingTipService {
    List<RecyclingTip> getAllRecyclingTips();

    RecyclingTip getRecyclingTipById(Long id);

    RecyclingTip createRecyclingTip(RecyclingTip recyclingTip);

    RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip);

    void deleteRecyclingTip(Long id);
}
