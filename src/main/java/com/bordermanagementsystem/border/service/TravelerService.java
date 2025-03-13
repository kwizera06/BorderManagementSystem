package com.bordermanagementsystem.border.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.repository.TravelerRepository;


@Service
public class TravelerService {

     @Autowired
    private TravelerRepository travelerRepository;

    // Create
    public Traveler createTraveler(Traveler traveler) {
        return travelerRepository.save(traveler);
    }

    // Read
    public Optional<Traveler> getTravelerById(Long travelerId) {
        return travelerRepository.findById(travelerId);
    }

    public Optional<Traveler> getTravelerByPassportNumber(String passportNumber) {
        return travelerRepository.findByPassportNumber(passportNumber);
    }

    public List<Traveler> getTravelersByNationality(String nationality) {
        return travelerRepository.findByNationality(nationality);
    }
    public List<Traveler> getAllTravelers() {
        return travelerRepository.findAll();
    }

    // Update
    public Traveler updateTraveler(Long travelerId, Traveler updatedTraveler) {
        if (travelerRepository.existsById(travelerId)) {
            updatedTraveler.setTravelerId(travelerId);
            return travelerRepository.save(updatedTraveler);
        }
        return null;
    }

    // Delete
    public void deleteTraveler(Long travelerId) {
        travelerRepository.deleteById(travelerId);
    }
}
