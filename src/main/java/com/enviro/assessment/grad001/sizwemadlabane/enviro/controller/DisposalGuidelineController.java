package com.enviro.assessment.grad001.sizwemadlabane.enviro.controller;


import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(disposalGuidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        DisposalGuideline disposalGuideline = disposalGuidelineService.getDisposalGuidelineById(id);
        return ResponseEntity.ok(disposalGuideline);
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdGuideline = disposalGuidelineService.createDisposalGuideline(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuideline updatedGuideline) {
        DisposalGuideline updated = disposalGuidelineService.updateDisposalGuideline(id, updatedGuideline);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
