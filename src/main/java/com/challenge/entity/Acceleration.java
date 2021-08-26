package com.challenge.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "acceleration")
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(name="name")
    private String name;
    
    @NotNull
    @Size(max = 50)
    @Column(name="slug")
    private String slug;
    
    @OneToMany
    private List<Candidate> candidates;
    
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    Challenge challenge;
    
    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
