import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Movie } from 'src/app/Movie';
@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent {
  @Input()
  movieList:Movie[]=[];
  @Output()
  deleteEvent:EventEmitter<number>= new EventEmitter<number>();
  deleteMovie(id:number):void{
    console.log(`deleting ${id}`);
    this.deleteEvent.emit(id);
  }
}
