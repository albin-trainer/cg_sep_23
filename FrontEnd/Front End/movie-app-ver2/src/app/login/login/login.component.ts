import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
 
  invalidLogin = false
  

  error:string=""

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin(evt:any) {
    evt.preventDefault();
console.log(this.username,this.password);

let loginData={"username":this.username,"password":this.password};
this.loginservice.authenticate(loginData).subscribe(

  (data:any)=>{console.log(data);
    sessionStorage.setItem("token","Bearer "+data.token);
    sessionStorage.setItem("username",this.username);
    this.router.navigate(["/movies"]) 
  }
  ,error=>{
    this.error="Invalid Login credentials";
    this.invalidLogin=true;
  }
  )
/*
    (this.loginservice.authenticate(loginData).subscribe(
      data => {
        console.log( "login  "+data)
        console.log(data.token)
        sessionStorage.setItem("token","Bearer "+data.token);
        sessionStorage.setItem("username",this.username);
        this.router.navigate(['/movies']).then(() => {
          window.location.reload();
        });
      
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
        console.log(error.message);
        
        this.error = "Invalid credentials Login Failed !!!!";

      }
    )
    );*/

  }

}
