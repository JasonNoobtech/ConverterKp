import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConversionService {
  private apiUrl = 'http://localhost:8080/api/convert'; // Backend URL

  constructor(private http: HttpClient) {}

  convert(conversionData: any): Observable<any> {
    return this.http.post(this.apiUrl, conversionData, { responseType: 'text' });
  }
}
