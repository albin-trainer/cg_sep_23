import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptorInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
   console.log("intercepting ......")
   let token:string=`${sessionStorage.getItem('token')}`;
   console.log("token : ",token)
   //const headers = req.headers.set('Authorization', token);
   
   if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
     console.log("inside if setting headers ")
     request = request.clone({headers: request.headers.set('Authorization', token)})
     console.log("req header :"+request.headers.get('Authorization'));
   }
    return next.handle(request);
  }
}
