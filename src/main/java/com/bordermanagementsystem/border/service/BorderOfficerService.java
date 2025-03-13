package com.bordermanagementsystem.border.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bordermanagementsystem.border.model.BorderOfficer;
import com.bordermanagementsystem.border.model.Checkpoint;
import com.bordermanagementsystem.border.repository.BorderOfficerRepository;

@Service
public class BorderOfficerService {

      @Autowired
    private BorderOfficerRepository borderOfficerRepository;

    // Create
    public BorderOfficer createBorderOfficer(BorderOfficer borderOfficer) {
        return borderOfficerRepository.save(borderOfficer);
    }

    // Read
    public Optional<BorderOfficer> getBorderOfficerById(Long officerId) {
        return borderOfficerRepository.findById(officerId);
    }

    public List<BorderOfficer> getBorderOfficersByCheckpoint(Checkpoint checkpoint) {
        return borderOfficerRepository.findByAssignedCheckpoint(checkpoint);
    }

    public List<BorderOfficer> getAllBorderOfficers() {
        return borderOfficerRepository.findAll();
    }

     // Update
     public BorderOfficer updateBorderOfficer(Long officerId, BorderOfficer updatedOfficer) {
        if (borderOfficerRepository.existsById(officerId)) {
            updatedOfficer.setOfficerId(officerId);
            return borderOfficerRepository.save(updatedOfficer);
        }
        return null;
    }

    // Delete
    public void deleteBorderOfficer(Long officerId) {
        borderOfficerRepository.deleteById(officerId);
    }
}
