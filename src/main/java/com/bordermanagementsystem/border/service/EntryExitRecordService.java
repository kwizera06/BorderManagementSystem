package com.bordermanagementsystem.border.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bordermanagementsystem.border.model.Checkpoint;
import com.bordermanagementsystem.border.model.EntryExitRecord;
import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.repository.EntryExitRecordRepository;

public class EntryExitRecordService {

     @Autowired
    private EntryExitRecordRepository entryExitRecordRepository;

    // Create
    public EntryExitRecord createEntryExitRecord(EntryExitRecord record) {
        return entryExitRecordRepository.save(record);
    }

    // Read
    public Optional<EntryExitRecord> getEntryExitRecordById(Long recordId) {
        return entryExitRecordRepository.findById(recordId);
    }

    public List<EntryExitRecord> getEntryExitRecordsByTraveler(Traveler traveler) {
        return entryExitRecordRepository.findByTraveler(traveler);
    }
     public List<EntryExitRecord> getEntryExitRecordsByCheckpoint(Checkpoint checkpoint) {
        return entryExitRecordRepository.findByCheckpoint(checkpoint);
    }

    public List<EntryExitRecord> getEntryExitRecordsByStatus(String status) {
        return entryExitRecordRepository.findByStatus(status);
    }

    public List<EntryExitRecord> getAllEntryExitRecords() {
        return entryExitRecordRepository.findAll();
    }

    // Update
    public EntryExitRecord updateEntryExitRecord(Long recordId, EntryExitRecord updatedRecord) {
        if (entryExitRecordRepository.existsById(recordId)) {
            updatedRecord.setRecordId(recordId);
            return entryExitRecordRepository.save(updatedRecord);
        }
        return null;
    }

    // Delete
    public void deleteEntryExitRecord(Long recordId) {
        entryExitRecordRepository.deleteById(recordId);
    }
}
