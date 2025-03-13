package com.bordermanagementsystem.border.model;

import jakarta.persistence.*;

@Entity
@Table(name = "checkpoints")
public class Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkpointId;
    private String name;
    private String location;
    private String country;
    public Long getCheckpointId() {
        return checkpointId;
    }
    public void setCheckpointId(Long checkpointId) {
        this.checkpointId = checkpointId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    
}