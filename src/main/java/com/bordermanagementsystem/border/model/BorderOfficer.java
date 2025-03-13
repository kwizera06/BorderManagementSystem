package com.bordermanagementsystem.border.model;

import jakarta.persistence.*;

@Entity
@Table(name = "border_officers")
public class BorderOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officerId;
    private String name;
    private String rank;
    
    @ManyToOne
    @JoinColumn(name = "checkpoint_id")
    private Checkpoint assignedCheckpoint;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Checkpoint getAssignedCheckpoint() {
        return assignedCheckpoint;
    }

    public void setAssignedCheckpoint(Checkpoint assignedCheckpoint) {
        this.assignedCheckpoint = assignedCheckpoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    
}