package com.bordermanagementsystem.border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bordermanagementsystem.border.model.Checkpoint;
import com.bordermanagementsystem.border.service.CheckpointService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/checkpoints")
public class CheckpointController {

    @Autowired
    private CheckpointService checkpointService;

    // Create Checkpoint
    @PostMapping
    public ResponseEntity<Checkpoint> createCheckpoint(@RequestBody Checkpoint checkpoint) {
        Checkpoint createdCheckpoint = checkpointService.createCheckpoint(checkpoint);
        return ResponseEntity.ok(createdCheckpoint);
    }

    // Get Checkpoint by ID
    @GetMapping("/{checkpointId}")
    public ResponseEntity<Checkpoint> getCheckpointById(@PathVariable Long checkpointId) {
        Optional<Checkpoint> checkpoint = checkpointService.getCheckpointById(checkpointId);
        return checkpoint.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Checkpoints by Country
    @GetMapping("/country/{country}")
    public List<Checkpoint> getCheckpointsByCountry(@PathVariable String country) {
        return checkpointService.getCheckpointsByCountry(country);
    }

    // Get All Checkpoints
    @GetMapping
    public List<Checkpoint> getAllCheckpoints() {
        return checkpointService.getAllCheckpoints();
    }

    // Update Checkpoint
    @PutMapping("/{checkpointId}")
    public ResponseEntity<Checkpoint> updateCheckpoint(@PathVariable Long checkpointId, @RequestBody Checkpoint updatedCheckpoint) {
        Checkpoint checkpoint = checkpointService.updateCheckpoint(checkpointId, updatedCheckpoint);
        return checkpoint != null ? ResponseEntity.ok(checkpoint) : ResponseEntity.notFound().build();
    }

    // Delete Checkpoint
    @DeleteMapping("/{checkpointId}")
    public ResponseEntity<Void> deleteCheckpoint(@PathVariable Long checkpointId) {
        checkpointService.deleteCheckpoint(checkpointId);
        return ResponseEntity.noContent().build();
    }
}
