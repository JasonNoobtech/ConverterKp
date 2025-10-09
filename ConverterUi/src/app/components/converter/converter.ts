import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {ConversionService} from '../../services/conversion/conversion';

@Component({
  selector: 'app-converter',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './converter.html',
  styleUrls: ['./converter.css']
})
export class ConverterComponent {
  conversionTypes = ['TEMPERATURE', 'LENGTH', 'WEIGHT', 'CURRENCY', 'SPEED'];
  fromUnits: string[] = [];
  toUnits: string[] = [];

  selectedType = '';
  from = '';
  to = '';
  value: number | null = null;
  result = '';

  constructor(private conversionService: ConversionService) {}

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
    if (!this.selectedType || !this.from || !this.to || this.value === null) {
      this.result = '⚠️ Please complete all fields before converting.';
      return;
    }

    const request = {
      type: this.selectedType,
      from: this.from,
      to: this.to,
      inputValue: this.value
    };

    this.conversionService.convert(request).subscribe({
      next: (res) => this.result = `Result: ${parseFloat(res).toFixed(2)}`,
      error: (err) => {
        console.error('Conversion error:', err);
        this.result = `Error: ${err.error || 'Server unavailable.'}`;
      }
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

export class Converter {
}
