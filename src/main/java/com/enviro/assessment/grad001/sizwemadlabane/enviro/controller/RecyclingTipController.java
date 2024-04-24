package com.enviro.assessment.grad001.sizwemadlabane.enviro.controller;

import com.enviro.assessment.grad001.sizwemadlabane.enviro.entity.RecyclingTip;
import com.enviro.assessment.grad001.sizwemadlabane.enviro.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(recyclingTips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTip recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return ResponseEntity.ok(recyclingTip);
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdTip = recyclingTipService.createRecyclingTip(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip updatedTip) {
        RecyclingTip updated = recyclingTipService.updateRecyclingTip(id, updatedTip);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}

