package com.bordermanagementsystem.border.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "travelers")
public class Traveler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelerId;
    private String name;
    private Date dob;
    private String nationality;
    private String passportNumber;
    public Long getTravelerId() {
        return travelerId;
    }
    public void setTravelerId(Long travelerId) {
        this.travelerId = travelerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    
}