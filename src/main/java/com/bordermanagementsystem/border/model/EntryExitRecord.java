package com.bordermanagementsystem.border.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "entry_exit_records")
public class EntryExitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;
    private Date entryDateTime;
    private Date exitDateTime;
    private String purpose;
    private String status; // Approved, Denied, Pending
    
    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler traveler;
    
    @ManyToOne
    @JoinColumn(name = "checkpoint_id")
    private Checkpoint checkpoint;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(Date entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Date getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(Date exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(Checkpoint checkpoint) {
        this.checkpoint = checkpoint;
    }



    
}
