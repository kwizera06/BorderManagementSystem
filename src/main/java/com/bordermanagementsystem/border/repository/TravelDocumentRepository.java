package com.bordermanagementsystem.border.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bordermanagementsystem.border.model.TravelDocument;
import com.bordermanagementsystem.border.model.Traveler;

@Repository
public interface TravelDocumentRepository extends JpaRepository<TravelDocument,Long> {


    Optional<Traveler> findByPassportNumber(String passportNumber);
    List<Traveler> findByNationality(String nationality);
    List<TravelDocument> findByTraveler(Traveler traveler);
    List<TravelDocument> findByTravelerAndType(Traveler traveler, String type);
}
