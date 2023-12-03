import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { RegistrationComponent } from './login/registration/registration.component';
import { MovieFormComponent } from './Movie/movie-form/movie-form.component';
import { MoviesComponent } from './Movie/movies/movies.component';
import { ReviewsComponent } from './Movie/reviews/reviews.component';
import { AuthGuardGuard } from './services/auth-guard.guard';

const routes: Routes = [
  {
    path:"movies",
    component:MoviesComponent,canActivate:[AuthGuardGuard]
  },
  {
    path:"addMovie/:id",
    component:MovieFormComponent,canActivate:[AuthGuardGuard]
  },
  {
    path:"",
    component:LoginComponent
  },
  {
    path:"reviews/:id",
    component:ReviewsComponent,canActivate:[AuthGuardGuard]
  },
  {
    path:"register",
    component:RegistrationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
