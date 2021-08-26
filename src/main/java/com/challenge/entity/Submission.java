package com.challenge.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "submission")
public class Submission {

	@EmbeddedId
    private SubmissionIdentity submissionIdentity;
	
	@NotNull
    @Column(name = "score")
    private float score;
	
    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
