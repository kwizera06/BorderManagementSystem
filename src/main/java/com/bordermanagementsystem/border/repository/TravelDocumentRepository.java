package com.bordermanagementsystem.border.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bordermanagementsystem.border.model.TravelDocument;
import com.bordermanagementsystem.border.model.Traveler;

@Repository
public interface TravelDocumentRepository extends JpaRepository<TravelDocument, Long> {

    // Corrected to return TravelDocument and navigate through Traveler
    Optional<TravelDocument> findByTraveler_PassportNumber(String passportNumber);
    
    // Corrected to return TravelDocument instead of Traveler
    List<TravelDocument> findByTraveler_Nationality(String nationality);

    // Fetch documents for a given traveler
    List<TravelDocument> findByTraveler(Traveler traveler);

    // Fetch documents for a traveler and a specific type
    List<TravelDocument> findByTravelerAndType(Traveler traveler, String type);

    // Alternative using JPQL for passportNumber lookup
    @Query("SELECT td FROM TravelDocument td WHERE td.traveler.passportNumber = :passportNumber")
    Optional<TravelDocument> findByPassportNumber(@Param("passportNumber") String passportNumber);
}


// package com.bordermanagementsystem.border.repository;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.bordermanagementsystem.border.model.TravelDocument;
// import com.bordermanagementsystem.border.model.Traveler;

// @Repository
// public interface TravelDocumentRepository extends JpaRepository<TravelDocument,Long> {


//     Optional<Traveler> findByPassportNumber(String passportNumber);
//     List<Traveler> findByNationality(String nationality);
//     List<TravelDocument> findByTraveler(Traveler traveler);
//     List<TravelDocument> findByTravelerAndType(Traveler traveler, String type);
// }
