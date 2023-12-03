import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/Movie';
import { DataServiceService } from 'src/app/services/data-service.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  searchText:string="";
  movies:Movie[]=[];
  orginal:Movie[]=[];
  constructor( private dataService:DataServiceService ){
    this.movies=[];
  this.orginal=this.movies;
  }
    //automatically invoked after the constructor ....
  ngOnInit(): void {
    this.dataService.getAllMovies().
    subscribe(movies=>{
      console.log(movies);
      this.movies=movies;
      this.orginal=movies;
    }
      );
  }
  
  search():void{
    console.log(`searching ${this.searchText}`);
    //  this.movies=  this.orginal.filter(m=>m.movieName==this.name);
    this.movies=  this.orginal.filter(m=>
      m.movieName.toLowerCase().indexOf(this.searchText.toLowerCase())>=0 ||
       m.language.toLowerCase().indexOf(this.searchText.toLowerCase())>=0);
  }
  deleteMovieById(id:number):void{
    console.log(`in Parent delte fn ${id}`);  
  //  this.movies=  this.orginal.filter(m=>m.id!=id);  
  this.movies= this.orginal= this.orginal.filter(m=>m.movieCode!=id);  
  //
 
}
}
