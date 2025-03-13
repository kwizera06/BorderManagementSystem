package com.bordermanagementsystem.border.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bordermanagementsystem.border.model.Checkpoint;

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint,Long> {


    List<Checkpoint> findByCountry(String country);
}
