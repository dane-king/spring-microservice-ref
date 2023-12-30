import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of} from 'rxjs';
import { Stock } from './model/stock';

@Injectable({
  providedIn: 'root'
})
export class QuoteService {
  //TODO: use environment variable to get the data
  url = "localhost:3000/stock-quote/";

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(private httpClient:HttpClient) { }


  getAllQuotes(): Observable<Stock[]> {
    return this.httpClient.get<Stock[]>(`${this.url}/quotes`);
  }

}
