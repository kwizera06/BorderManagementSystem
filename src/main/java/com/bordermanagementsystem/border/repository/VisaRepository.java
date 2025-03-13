package com.bordermanagementsystem.border.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.model.Visa;

@Repository
public interface VisaRepository extends JpaRepository<Visa,Long> {

List<Visa> findByTraveler(Traveler traveler);
    List<Visa> findByStatus(String status);
}
