import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DataServiceService } from 'src/app/services/data-service.service';
import { ConfirmPasswordValidator } from './confirm-password.validator';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
registrationForm:FormGroup;
constructor(private formBuilder:FormBuilder, private dataService:DataServiceService,
  private router:Router){
   /* this.registrationForm=new FormGroup({
      userName:new FormControl('',Validators.required),
      password:new FormControl('',[Validators.required,Validators.minLength(5)]),
    });*/
    
  this.registrationForm=this.formBuilder.group(
   { "username" :['',[Validators.required,Validators.email]],
   "password":['', [Validators.required,  Validators.minLength(5)] ],
   "confpassword":['', Validators.required ],
   "role":['',Validators.required]},
  
   {
     validator: ConfirmPasswordValidator("password", "confpassword")
   }
  );
}
get forms(){
  //console.log(this.registrationForm.controls)
  return this.registrationForm.controls;
}

submit():void{
  console.log("Works")
  console.log(this.registrationForm.value)
  this.dataService.newRegistration(this.registrationForm.value)
  .subscribe((res=>{
    alert("Registred");
    this.router.navigate(["/"])
  }));
  }
}
