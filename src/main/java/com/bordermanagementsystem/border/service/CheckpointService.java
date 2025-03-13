package com.bordermanagementsystem.border.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bordermanagementsystem.border.model.Checkpoint;
import com.bordermanagementsystem.border.repository.CheckpointRepository;

public class CheckpointService {

    @Autowired
    private CheckpointRepository checkpointRepository;

    // Create
    public Checkpoint createCheckpoint(Checkpoint checkpoint) {
        return checkpointRepository.save(checkpoint);
    }

    // Read
    public Optional<Checkpoint> getCheckpointById(Long checkpointId) {
        return checkpointRepository.findById(checkpointId);
    }

    public List<Checkpoint> getCheckpointsByCountry(String country) {
        return checkpointRepository.findByCountry(country);
    }

    public List<Checkpoint> getAllCheckpoints() {
        return checkpointRepository.findAll();
    }

    // Update
    public Checkpoint updateCheckpoint(Long checkpointId, Checkpoint updatedCheckpoint) {
        if (checkpointRepository.existsById(checkpointId)) {
            updatedCheckpoint.setCheckpointId(checkpointId);
            return checkpointRepository.save(updatedCheckpoint);
        }
        return null;
    }

    // Delete
    public void deleteCheckpoint(Long checkpointId) {
        checkpointRepository.deleteById(checkpointId);
    }
}
