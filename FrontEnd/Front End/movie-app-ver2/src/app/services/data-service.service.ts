import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../Movie';
import { Review } from '../Review';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
   baseUrl:string="http://localhost:9999/movies";

  constructor(private httpClient:HttpClient) {

   }
   getAllMovies()  : Observable<Movie[]>  {
      //new Request .. it has to attach the Token ....
      return this.httpClient.get<Movie[]> (this.baseUrl);

   }
   getMovieById(id:number):Observable<Movie>{
      return this.httpClient.get<Movie> (`${this.baseUrl}/${id}`);

   }
   addMovie(movie:Movie):Observable<Movie>{
      return this.httpClient.post<Movie>
      (this.baseUrl,movie);
   }
   addReview(review:Review):Observable<Review>{
      return this.httpClient.post<Review>(`${this.baseUrl}/${review.movieCode}/reviews`,review);
   }

   getReviews(movCode:number):Observable<Review[]>{
      return this.httpClient.get<Review[]>(`${this.baseUrl}/${movCode}/reviews`);
   }
   newRegistration(user:any):Observable<any>{
      return this.httpClient.post<any>("http://localhost:9999/register",user);
   }
}
