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
  valueTxt: string = '';
  result = '';

  updateUnits(): void {
    switch (this.selectedType) {
      case 'TEMPERATURE':
        this.fromUnits = ['Celsius', 'Fahrenheit', 'Kelvin'];
        break;
      case 'DISTANCE':
        this.fromUnits = ['Astronomical Units', 'Angstroms', 'Light Years', 'Furlongs', 'Parsecs', 'Miles',
          'Yards', 'Feet', 'Inches', 'Kilometres', 'Metres', 'Centimetres', 'Millimetres',
          'Nanometres', 'Rugby Fields', 'Football Fields', 'Bananas', 'Empire State Buildings',
          'Giraffes', 'Double Decker Busses', 'Paperclips', 'Eiffel Towers', 'Burj Khalifas'];
        break;
      case 'WEIGHT':
        this.fromUnits = ['Kilograms', 'Pounds', 'Ounces', 'Grams', 'Tonnes', 'Bananas', 'Paperclips',
          'Elephants', 'Blue Whales', 'Feathers', 'Bowling Balls', 'Hamsters', 'RG Snymans', 'Arnold Schwarzeneggers',
          'Smartphones', 'Slices of Pizza', 'Double Cheeseburgers'];
        break;
      case 'DIGITAL STORAGE':
        this.fromUnits = ['Bits', 'Kilobits', 'Megabits', 'Gigabits', 'Terabits', 'Petabits', 'Bytes', 'Kilobytes',
          'Megabytes', 'Gigabytes', 'Terabytes', 'Petabytes'];
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

  private wordToNumber: { [key: string]: number } = {
    'zero': 0, 'one': 1, 'two': 2, 'three': 3, 'four': 4, 'five': 5, 'six': 6, 'seven': 7, 'eight': 8, 'nine': 9,
    'ten': 10, 'eleven': 11, 'twelve': 12, 'thirteen': 13, 'fourteen': 14, 'fifteen': 15, 'sixteen': 16, 'seventeen': 17,
    'eighteen': 18, 'nineteen': 19, 'twenty': 20, 'thirty': 30, 'forty': 40, 'fifty': 50, 'sixty': 60, 'seventy': 70,
    'eighty': 80, 'ninety': 90, 'hundred': 100, 'thousand': 1000, 'million': 1000000, 'billion': 1000000000,
  };

  typeSelector(): void {
    console.log('typeSelector called with valueTxt:', `'${this.valueTxt}'`);

    if (this.valueTxt.trim()) {
      // First, try to parse as a regular number
      const numericValue = parseFloat(this.valueTxt);
      if (!isNaN(numericValue)) {
        this.value = numericValue;
        return;
      }

      // If not a number, try word conversion
      const words = this.valueTxt.toLowerCase().split(/[\s-]+/);
      let total = 0;
      let current = 0;
      let negative = false;
      let minus = false;

      console.log('Converting words:', words);

      if (words[0] === 'negative' || 'minus') {
        negative = true;
        minus = true;
        words.shift();
      }

      for (const i of words) {
        if (i === 'and') continue;
        const value = this.wordToNumber[i];
        console.log(`Word: ${i}, Value: ${value}`);
        if (value !== undefined) {
          if (value >= 100) {
            if (current === 0) current = 1;
            current *= value;
            if (value >= 1000) {
              total += current;
              current = 0;
            }
          } else {
            current += value;
          }
        }
      }

      console.log(`Final: total=${total}, current=${current}`);
      this.value = total + current > 0 ? total + current : null;
      this.value = (minus || negative) && this.value !== null ? -this.value : this.value;
      console.log('Final value:', this.value);
    } else {
      this.value = null;
    }
  }

  convert(): void {
    this.typeSelector();

    if (this.value === null || !this.selectedType || !this.from || !this.to) {
      this.result = "Please enter a valid number and select conversion options";
      return;
    }

    const request = {
      type: this.selectedType.replace(/\s+/g, '_'),
      from: this.from,
      to: this.to,
      inputValue: Number(this.value)
    };

    console.log('Sending request:', request);

    this.http.post('http://localhost:8080/api/convert', request, { responseType: 'text' })
      .subscribe({
        next: (res) => {
          const num = parseFloat(res);
          this.result = 'Result: ' + num.toLocaleString('en-US',
            { maximumFractionDigits: 4 }).replace(/,/g, ' ');
        },
        error: (err) => {
          console.error('Full error:', err);
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
    this.valueTxt = '';
    this.result = '';
    this.fromUnits = [];
    this.toUnits = [];
  }

  protected readonly isNaN = isNaN;
  protected readonly parseFloat = parseFloat;
}
