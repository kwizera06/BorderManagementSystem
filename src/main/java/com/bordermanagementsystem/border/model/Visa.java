package com.bordermanagementsystem.border.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "visas")
public class Visa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visaId;
    private String type;
    private Date issueDate;
    private Date expiryDate;
    private String status; // Active, Expired, Revoked
    
    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler traveler;

    public Long getVisaId() {
        return visaId;
    }

    public void setVisaId(Long visaId) {
        this.visaId = visaId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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
