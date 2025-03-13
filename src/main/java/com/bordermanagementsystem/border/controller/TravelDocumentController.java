package com.bordermanagementsystem.border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bordermanagementsystem.border.model.TravelDocument;
import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.service.TravelDocumentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/travel-documents")
public class TravelDocumentController {

    @Autowired
    private TravelDocumentService travelDocumentService;

    // Create Travel Document
    @PostMapping
    public ResponseEntity<TravelDocument> createTravelDocument(@RequestBody TravelDocument document) {
        TravelDocument createdDocument = travelDocumentService.createTravelDocument(document);
        return ResponseEntity.ok(createdDocument);
    }

    // Get Travel Document by ID
    @GetMapping("/{documentId}")
    public ResponseEntity<TravelDocument> getTravelDocumentById(@PathVariable Long documentId) {
        Optional<TravelDocument> document = travelDocumentService.getTravelDocumentById(documentId);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Travel Documents by Traveler
    @GetMapping("/traveler/{travelerId}")
    public List<TravelDocument> getTravelDocumentsByTraveler(@PathVariable Long travelerId) {
        Traveler traveler = new Traveler(); // This should ideally be fetched using travelerId
        traveler.setTravelerId(travelerId);
        return travelDocumentService.getTravelDocumentsByTraveler(traveler);
    }

    // Get All Travel Documents
    @GetMapping
    public List<TravelDocument> getAllTravelDocuments() {
        return travelDocumentService.getAllTravelDocuments();
    }

    // Update Travel Document
    @PutMapping("/{documentId}")
    public ResponseEntity<TravelDocument> updateTravelDocument(@PathVariable Long documentId, @RequestBody TravelDocument updatedDocument) {
        TravelDocument document = travelDocumentService.updateTravelDocument(documentId, updatedDocument);
        return document != null ? ResponseEntity.ok(document) : ResponseEntity.notFound().build();
    }

    // Delete Travel Document
    @DeleteMapping("/{documentId}")
    public ResponseEntity<Void> deleteTravelDocument(@PathVariable Long documentId) {
        travelDocumentService.deleteTravelDocument(documentId);
        return ResponseEntity.noContent().build();
    }
}
