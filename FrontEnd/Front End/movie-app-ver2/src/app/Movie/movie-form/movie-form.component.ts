import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Movie } from 'src/app/Movie';
import { DataServiceService } from 'src/app/services/data-service.service';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.css']
})
export class MovieFormComponent implements OnInit {
 movie:Movie={
  movieCode:0,"movieName":"",
  language:"",poster:"",
  genre:""
 };
 isAdd:boolean=false;
 toDo="Edit";
 constructor (private dataService:DataServiceService,
   private router:Router,private route:ActivatedRoute){

 }
  ngOnInit(): void {
    this.route.params.subscribe( (params:Params)=>{
      let id =params['id'];
      if(id<=0){
        this.isAdd=true;
        this.toDo="Add";
      }
      else
       this.getMovie(id);
    }
    )
  }
  getMovie(id:number):void{
    this.dataService.getMovieById(id).subscribe(m=>{
      console.log("got")
      this.movie=m;
    })
  }
 addMovie():void{
  console.log(this.movie);
  this.dataService.addMovie(this.movie).
  subscribe(res=>
  {
    alert("Added");
    this.router.navigate(["/movies"]);
  })
 }
 cancel():void{
  this.router.navigate(["/movies"])
 }
}
