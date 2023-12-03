package com.cg.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Movie;
@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
//findBy<FieldName> //Query Methods
 List<Movie> findByGenre(String genre);
 //@Query(value = "select * from movie where language = :lang ",nativeQuery = true)
 @Query(name = "searchBy_lang_native" )
 //here method name can be anyname
 List<Movie> searchMovieByLanguages(@Param("lang") String lang);
 
 @Query(value = "update Movie set genre=:g where movie_code= :mc",nativeQuery = true)
 @Modifying //for update, insert & delete queries .....
 int updateGenre(@Param("g") String genre, @Param("mc") int movieCode);
}
