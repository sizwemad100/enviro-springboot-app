package com.enviro.assessment.grad001.sizwemadlabane.enviro.service;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.DisposalGuideline;

import java.util.List;

public interface DisposalGuidelineService {
    List<DisposalGuideline> getAllDisposalGuidelines();

    DisposalGuideline getDisposalGuidelineById(Long id);

    DisposalGuideline createDisposalGuideline(DisposalGuideline disposalGuideline);

    DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline);

    void deleteDisposalGuideline(Long id);
}
