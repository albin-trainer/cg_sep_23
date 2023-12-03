import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieCardComponent } from './Movie/movie-card/movie-card.component';
import { MovieFormComponent } from './Movie/movie-form/movie-form.component';
import { MoviesComponent } from './Movie/movies/movies.component';
import {HttpClientModule, HTTP_INTERCEPTORS}
 from '@angular/common/http';
import { LoginComponent } from './login/login/login.component';
import { JwtInterceptorInterceptor } from './services/jwt-interceptor.interceptor';
import { ReviewsComponent } from './Movie/reviews/reviews.component';
import { RegistrationComponent } from './login/registration/registration.component';
@NgModule({
  declarations: [
    AppComponent,
    MovieCardComponent,
    MovieFormComponent,
    MoviesComponent,
    LoginComponent,
    ReviewsComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,
    HttpClientModule,ReactiveFormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, 
    useClass: JwtInterceptorInterceptor, multi: true }],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
