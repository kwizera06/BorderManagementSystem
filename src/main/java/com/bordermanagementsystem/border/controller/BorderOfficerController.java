package com.bordermanagementsystem.border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bordermanagementsystem.border.model.BorderOfficer;
import com.bordermanagementsystem.border.model.Checkpoint;
import com.bordermanagementsystem.border.service.BorderOfficerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/border-officers")
public class BorderOfficerController {

    @Autowired
    private BorderOfficerService borderOfficerService;

    // Create Border Officer
    @PostMapping
    public ResponseEntity<BorderOfficer> createBorderOfficer(@RequestBody BorderOfficer borderOfficer) {
        BorderOfficer createdOfficer = borderOfficerService.createBorderOfficer(borderOfficer);
        return ResponseEntity.ok(createdOfficer);
    }

    // Get Border Officer by ID
    @GetMapping("/{officerId}")
    public ResponseEntity<BorderOfficer> getBorderOfficerById(@PathVariable Long officerId) {
        Optional<BorderOfficer> officer = borderOfficerService.getBorderOfficerById(officerId);
        return officer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Border Officers by Checkpoint
    @GetMapping("/checkpoint/{checkpointId}")
    public List<BorderOfficer> getBorderOfficersByCheckpoint(@PathVariable Long checkpointId) {
        Checkpoint checkpoint = new Checkpoint(); // This should ideally be fetched using checkpointId
        checkpoint.setCheckpointId(checkpointId);
        return borderOfficerService.getBorderOfficersByCheckpoint(checkpoint);
    }

    // Get All Border Officers
    @GetMapping
    public List<BorderOfficer> getAllBorderOfficers() {
        return borderOfficerService.getAllBorderOfficers();
    }

    // Update Border Officer
    @PutMapping("/{officerId}")
    public ResponseEntity<BorderOfficer> updateBorderOfficer(@PathVariable Long officerId, @RequestBody BorderOfficer updatedOfficer) {
        BorderOfficer officer = borderOfficerService.updateBorderOfficer(officerId, updatedOfficer);
        return officer != null ? ResponseEntity.ok(officer) : ResponseEntity.notFound().build();
    }

    // Delete Border Officer
    @DeleteMapping("/{officerId}")
    public ResponseEntity<Void> deleteBorderOfficer(@PathVariable Long officerId) {
        borderOfficerService.deleteBorderOfficer(officerId);
        return ResponseEntity.noContent().build();
    }
}
