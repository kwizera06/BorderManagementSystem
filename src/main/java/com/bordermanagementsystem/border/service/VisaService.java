package com.bordermanagementsystem.border.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.model.Visa;
import com.bordermanagementsystem.border.repository.VisaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisaService {

    @Autowired
    private VisaRepository visaRepository;

    // Create
    public Visa createVisa(Visa visa) {
        return visaRepository.save(visa);
    }

    // Read
    public Optional<Visa> getVisaById(Long visaId) {
        return visaRepository.findById(visaId);
    }

    public List<Visa> getVisasByTraveler(Traveler traveler) {
        return visaRepository.findByTraveler(traveler);
    }

    public List<Visa> getVisasByStatus(String status) {
        return visaRepository.findByStatus(status);
    }

    public List<Visa> getAllVisas() {
        return visaRepository.findAll();
    }

    // Update
    public Visa updateVisa(Long visaId, Visa updatedVisa) {
        if (visaRepository.existsById(visaId)) {
            updatedVisa.setVisaId(visaId);
            return visaRepository.save(updatedVisa);
        }
        return null;
    }

    // Delete
    public void deleteVisa(Long visaId) {
        visaRepository.deleteById(visaId);
    }
}

