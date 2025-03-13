// package com.bordermanagementsystem.border.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.bordermanagementsystem.border.model.TravelDocument;
// import com.bordermanagementsystem.border.model.Traveler;
// import com.bordermanagementsystem.border.repository.TravelDocumentRepository;

// public class TravelDocumentService {

//    @Autowired
//     private TravelDocumentRepository travelDocumentRepository;

//     // Create
//     public TravelDocument createTravelDocument(TravelDocument document) {
//         return travelDocumentRepository.save(document);
//     }

//     // Read
//     public Optional<TravelDocument> getTravelDocumentById(Long documentId) {
//         return travelDocumentRepository.findById(documentId);
//     }

//     public List<TravelDocument> getTravelDocumentsByTraveler(Traveler traveler) {
//         return travelDocumentRepository.findByTraveler(traveler);
//     }

//     public List<TravelDocument> getTravelDocumentsByTravelerAndType(Traveler traveler, String type) {
//         return travelDocumentRepository.findByTravelerAndType(traveler, type);
//     }
//     public List<TravelDocument> getAllTravelDocuments() {
//         return travelDocumentRepository.findAll();
//     }

//     // Update
//     public TravelDocument updateTravelDocument(Long documentId, TravelDocument updatedDocument) {
//         if (travelDocumentRepository.existsById(documentId)) {
//             updatedDocument.setDocumentId(documentId);
//             return travelDocumentRepository.save(updatedDocument);
//         }
//         return null;
//     }

//     // Delete
//     public void deleteTravelDocument(Long documentId) {
//         travelDocumentRepository.deleteById(documentId);
//     }
// }
package com.bordermanagementsystem.border.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bordermanagementsystem.border.model.TravelDocument;
import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.repository.TravelDocumentRepository;
import com.bordermanagementsystem.border.repository.TravelerRepository;

@Service
public class TravelDocumentService {

    @Autowired
    private TravelDocumentRepository travelDocumentRepository;

    @Autowired
    private TravelerRepository travelerRepository;

    // Create
    public TravelDocument createTravelDocument(TravelDocument document) {
        // Ensure Traveler exists before associating
        Traveler traveler = document.getTraveler();
        if (traveler != null && travelerRepository.existsById(traveler.getTravelerId())) {
            return travelDocumentRepository.save(document);
        }
        return null;  // Return null if the traveler doesn't exist
    }

    // Read
    public Optional<TravelDocument> getTravelDocumentById(Long documentId) {
        return travelDocumentRepository.findById(documentId);
    }

    public List<TravelDocument> getTravelDocumentsByTraveler(Traveler traveler) {
        return travelDocumentRepository.findByTraveler(traveler);
    }

    public List<TravelDocument> getTravelDocumentsByTravelerAndType(Traveler traveler, String type) {
        return travelDocumentRepository.findByTravelerAndType(traveler, type);
    }

    public List<TravelDocument> getAllTravelDocuments() {
        return travelDocumentRepository.findAll();
    }

    // Update
    public TravelDocument updateTravelDocument(Long documentId, TravelDocument updatedDocument) {
        if (travelDocumentRepository.existsById(documentId)) {
            updatedDocument.setDocumentId(documentId);
            return travelDocumentRepository.save(updatedDocument);
        }
        return null;
    }

    // Delete
    public void deleteTravelDocument(Long documentId) {
        travelDocumentRepository.deleteById(documentId);
    }

    // Extra: Example method to fetch a travel document by passport number
    public List<TravelDocument> getTravelDocumentsByPassportNumber(String passportNumber) {
        Optional<Traveler> travelerOpt = travelerRepository.findByPassportNumber(passportNumber);
        if (travelerOpt.isPresent()) {
            return travelDocumentRepository.findByTraveler(travelerOpt.get());
        }
        return null;  // Return null if traveler with passport number is not found
    }
}
