package com.bordermanagementsystem.border.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bordermanagementsystem.border.model.Checkpoint;
import com.bordermanagementsystem.border.model.EntryExitRecord;
import com.bordermanagementsystem.border.model.Traveler;

@Repository
public interface EntryExitRecordRepository extends JpaRepository<EntryExitRecord,Long>{

List<EntryExitRecord> findByTraveler(Traveler traveler);
    List<EntryExitRecord> findByCheckpoint(Checkpoint checkpoint);
    List<EntryExitRecord> findByStatus(String status);
}
