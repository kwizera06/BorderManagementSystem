package com.bordermanagementsystem.border.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bordermanagementsystem.border.model.Blacklist;
import com.bordermanagementsystem.border.model.Traveler;
import com.bordermanagementsystem.border.repository.BlacklistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlacklistService {

    @Autowired
    private BlacklistRepository blacklistRepository;

    // Create
    public Blacklist createBlacklist(Blacklist blacklist) {
        return blacklistRepository.save(blacklist);
    }

    // Read
    public Optional<Blacklist> getBlacklistById(Long blacklistId) {
        return blacklistRepository.findById(blacklistId);
    }

    public Optional<Blacklist> getBlacklistByTraveler(Traveler traveler) {
        return blacklistRepository.findByTraveler(traveler);
    }

    public List<Blacklist> getBlacklistsByStatus(String status) {
        return blacklistRepository.findByStatus(status);
    }

    public List<Blacklist> getAllBlacklists() {
        return blacklistRepository.findAll();
    }

    // Update
    public Blacklist updateBlacklist(Long blacklistId, Blacklist updatedBlacklist) {
        if (blacklistRepository.existsById(blacklistId)) {
            updatedBlacklist.setBlacklistId(blacklistId);
            return blacklistRepository.save(updatedBlacklist);
        }
        return null;
    }

    // Delete
    public void deleteBlacklist(Long blacklistId) {
        blacklistRepository.deleteById(blacklistId);
    }
}
