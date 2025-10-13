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
  conversionTypes = ['TEMPERATURE', 'CURRENCY', 'DIGITAL STORAGE', 'DISTANCE', 'WEIGHT'];
  fromUnits: string[] = [];
  toUnits: string[] = [];

  selectedType = '';
  from = '';
  to = '';
  value: number | null = null;
  result = '';

  updateUnits(): void {
    switch (this.selectedType) {
      case 'TEMPERATURE':
        this.fromUnits = ['Celsius', 'Fahrenheit', 'Kelvin'];
        break;
      case 'DISTANCE':
        this.fromUnits = ['Astronomical Units', 'Angstroms', 'Light Years', 'Furlongs', 'Parsecs', 'Miles', 'Yards', 'Feet', 'Inches', 'Kilometres',
        'Metres', 'Centimetres', 'Millimetres', 'Nanometres', 'Bananas', 'Football Fields', 'Empire State Buildings', 'Giraffes', 'Double Decker Busses', 'Paperclips', 'Eiffel Towers'];
        break;
      case 'WEIGHT':
        this.fromUnits = ['Kilograms', 'Pounds', 'Ounces', 'Grams', 'Tonnes', 'Bananas', 'Paperclips', 'Elephants', 'Blue Whales', 'Feathers', 'Bowling Balls', 'Hamsters',
          'Smartphones', 'Slices of Pizza'];
        break;
      case 'DIGITAL STORAGE':
        this.fromUnits = ['Bits', 'Kilobits', 'Kibibits', 'Megabits', 'Mebibits', 'Gigabits', 'Gibibits', 'Terabits', 'Tebibits',
          'Petabits', 'Pebibits', 'Bytes', 'Kilobytes', 'Kibibytes', 'Megabytes', 'Mebibytes', 'Gigabytes', 'Gibibytes', 'Terabytes',
          'Tebibytes', 'Petabytes', 'Pebibytes'];
        break;
      case 'CURRENCY':
        this.fromUnits = ['Rand', 'Pound', 'Yen', 'Euro', 'Yuan', 'Dollar', 'Netherlands Antillean Guilder',
          'Armenian Dram', 'Somali Shilling', 'Zimbabwean Dollar'];
        break;
      default:
        this.fromUnits = [];
    }
    this.toUnits = [...this.fromUnits];
    this.from = '';
    this.to = '';
  }

  constructor(private http: HttpClient) {}

  convert(): void {
    const request = {
      type: this.selectedType.replace(' ', '_'),
      from: this.from,
      to: this.to,
      inputValue: this.value
    };

    this.http.post('http://localhost:8080/api/convert', request, { responseType: 'text' })
      .subscribe({
        next: (res) => this.result = `Result: ${parseFloat(res).toFixed(4)}`,
        error: (err) => {
          console.error('Error response:', err);
          const backendMessage =
            typeof err.error === 'string'
              ? err.error
              : err.error?.message || 'Unknown error from backend';

          this.result = `${backendMessage}`;
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
