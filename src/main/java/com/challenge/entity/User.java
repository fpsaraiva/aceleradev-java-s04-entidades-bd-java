package com.challenge.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
    
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "user")
    private List<Submission> submissions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Candidate> candidates;
}
