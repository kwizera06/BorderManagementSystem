package com.bordermanagementsystem.border.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bordermanagementsystem.border.model.Blacklist;
import com.bordermanagementsystem.border.model.Traveler;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist,Long> {

Optional<Blacklist> findByTraveler(Traveler traveler);
    List<Blacklist> findByStatus(String status);
}
