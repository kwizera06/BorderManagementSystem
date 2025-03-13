package com.bordermanagementsystem.border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.service.TravelerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/travelers")
public class TravelerController {

    @Autowired
    private TravelerService travelerService;

    // Create Traveler
    @PostMapping
    public ResponseEntity<Traveler> createTraveler(@RequestBody Traveler traveler) {
        Traveler createdTraveler = travelerService.createTraveler(traveler);
        return ResponseEntity.ok(createdTraveler);
    }

    // Get Traveler by ID
    @GetMapping("/{travelerId}")
    public ResponseEntity<Traveler> getTravelerById(@PathVariable Long travelerId) {
        Optional<Traveler> traveler = travelerService.getTravelerById(travelerId);
        return traveler.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Traveler by Passport Number
    @GetMapping("/passport/{passportNumber}")
    public ResponseEntity<Traveler> getTravelerByPassportNumber(@PathVariable String passportNumber) {
        Optional<Traveler> traveler = travelerService.getTravelerByPassportNumber(passportNumber);
        return traveler.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Travelers by Nationality
    @GetMapping("/nationality/{nationality}")
    public List<Traveler> getTravelersByNationality(@PathVariable String nationality) {
        return travelerService.getTravelersByNationality(nationality);
    }

    // Get All Travelers
    @GetMapping
    public List<Traveler> getAllTravelers() {
        return travelerService.getAllTravelers();
    }

    // Update Traveler
    @PutMapping("/{travelerId}")
    public ResponseEntity<Traveler> updateTraveler(@PathVariable Long travelerId, @RequestBody Traveler updatedTraveler) {
        Traveler traveler = travelerService.updateTraveler(travelerId, updatedTraveler);
        return traveler != null ? ResponseEntity.ok(traveler) : ResponseEntity.notFound().build();
    }

    // Delete Traveler
    @DeleteMapping("/{travelerId}")
    public ResponseEntity<Void> deleteTraveler(@PathVariable Long travelerId) {
        travelerService.deleteTraveler(travelerId);
        return ResponseEntity.noContent().build();
    }
}

