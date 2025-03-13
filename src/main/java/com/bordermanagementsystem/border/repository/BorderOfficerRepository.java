package com.bordermanagementsystem.border.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bordermanagementsystem.border.model.BorderOfficer;
import com.bordermanagementsystem.border.model.Checkpoint;

@Repository
public interface BorderOfficerRepository extends JpaRepository<BorderOfficer,Long> {

    
  List<BorderOfficer> findByAssignedCheckpoint(Checkpoint checkpoint);
}
