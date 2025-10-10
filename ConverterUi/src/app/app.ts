import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  conversionTypes = ['TEMPERATURE', 'LENGTH', 'WEIGHT', 'CURRENCY', 'SPEED'];
  fromUnits: string[] = [];
  toUnits: string[] = [];

  selectedType = '';
  from = '';
  to = '';
  value: number | null = null;
  result = '';

  constructor(private http: HttpClient) {}

  updateUnits(): void {
    switch (this.selectedType) {
      case 'TEMPERATURE':
        this.fromUnits = ['Celsius', 'Fahrenheit', 'Kelvin'];
        break;
      case 'LENGTH':
        this.fromUnits = ['Meters', 'Feet', 'Inches', 'Centimeters', 'Yards', 'Lightyears'];
        break;
      case 'WEIGHT':
        this.fromUnits = ['Kilograms', 'Pounds', 'Ounces', 'Grams', 'Tons'];
        break;
      case 'CURRENCY':
        this.fromUnits = ['Rand', 'EUR', 'GBP', 'JPY', 'CAD', 'USD'];
        break;
      case 'SPEED':
        this.fromUnits = ['Meters per second', 'Kilometers per hour', 'Miles per hour', 'Knots'];
        break;
      default:
        this.fromUnits = [];
    }
    this.toUnits = [...this.fromUnits];
    this.from = '';
    this.to = '';
  }

  convert(): void {
    const request = {
      type: this.selectedType,
      from: this.from,
      to: this.to,
      inputValue: this.value
    };

    this.http.post('http://localhost:8080/api/convert', request, { responseType: 'text' })
      .subscribe({
        next: (res) => this.result = `Result: ${parseFloat(res).toFixed(2)}`,
        error: () => this.result = 'Error: Could not convert'
      });
  }

  clear(): void {
    this.selectedType = '';
    this.from = '';
    this.to = '';
    this.value = null;
    this.result = '';
    this.fromUnits = [];
    this.toUnits = [];
  }
}
