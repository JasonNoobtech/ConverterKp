import { Component } from '@angular/core';
import { ConverterComponent } from './components/converter/converter';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ConverterComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App { }
