package com.bordermanagementsystem.border.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "blacklist")
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blacklistId;
    private String reason;
    private Date dateAdded;
    private String status; // Active, Cleared
    
    @OneToOne
    @JoinColumn(name = "traveler_id")
    private Traveler traveler;

    public Long getBlacklistId() {
        return blacklistId;
    }

    public void setBlacklistId(Long blacklistId) {
        this.blacklistId = blacklistId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }


    
}