package com.cg.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Review {
	@Id
	@GeneratedValue
private int reviewId;
private String reviewerName;
private String reviewMsg;
private float ratings;
@ManyToOne
@JoinColumn(name="movieCode")
@JsonIgnore
private Movie movie;



}
