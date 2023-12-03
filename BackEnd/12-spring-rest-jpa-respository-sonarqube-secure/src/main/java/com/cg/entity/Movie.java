package com.cg.entity;
import java.time.LocalDate;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//only JPQL
@NamedQuery(name = "search_By_Lang",
query ="select m from Movie m where m.language = :lang" )
//For Native queries
@NamedNativeQuery(name="searchBy_lang_native",
query= "select * from movie where language= :lang",resultClass = Movie.class)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue
private int movieCode;
	@NotNull(message = "Movie name required")
	private String movieName;
private String language;
private String genre;
private String poster;
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate releaseDate;


}
