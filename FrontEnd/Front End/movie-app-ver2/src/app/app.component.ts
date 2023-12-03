import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from './Movie';
import { AuthenticationService } from './services/authentication.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
 // template:`<p>Helllo</p> 
 //           <h1>Good morning {{name}}</h1> `,
  styleUrls: ['./app.component.css']
})
export class AppComponent   {
  title = 'movie-app-ver1'; 
  constructor(private router:Router, public authService:AuthenticationService){

  }
 logout():void{
  sessionStorage.removeItem("token");
  sessionStorage.removeItem("username");

  this.router.navigate([""])
 }
}
