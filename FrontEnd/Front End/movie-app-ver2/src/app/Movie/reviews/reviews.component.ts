import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Review } from 'src/app/Review';
import { DataServiceService } from 'src/app/services/data-service.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent  implements OnInit{
review:Review={
  reviewId:0,
  ratings:0,
  reviewerName:"",
  reviewMsg:"",
  movieCode:0
};
mCode:number=0;
reviewerName:string="test";
reviewList:Review[]=[];
constructor (private dataService:DataServiceService,
  private router:Router,private route:ActivatedRoute){

}
ngOnInit(): void {
  this.route.params.subscribe( (params:Params)=>{
    let id =params['id'];
   this.review.movieCode=id;
  })
  this.review.reviewerName= `${sessionStorage.getItem('username')}`;
  console.log(this.reviewerName)
  this.dataService.getReviews(this.review.movieCode).subscribe(result=>{
    this.reviewList=result;
    console.log(result)
    console.log("Reviews :"+this.reviewList);
  });
  
}
cancel():void{
  this.router.navigate(["movies"]);
}
addReview():void{
 console.log(this.review)
 this.dataService.addReview(this.review).subscribe(r=>{
  console.log("Added");
 this.router.navigate(["movies"]);
})
}
}
