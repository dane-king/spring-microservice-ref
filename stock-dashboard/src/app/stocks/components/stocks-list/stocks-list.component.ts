import { Component, OnInit } from '@angular/core';
import { Stock } from '../../model/stock';


const ELEMENT_DATA: Stock[] = [
  {ticker:'IBM', name: 'International Business Machine', last: 124.35, change: .62, percent_change: .01},
  {ticker:'AAPL', name: 'Apple Inc', last: 167.30, change: -1.58, percent_change: -.5},
  {ticker:'NOK', name: 'Nokia', last: 5.66, change: .01, percent_change: .01},
];


@Component({
  selector: 'app-stocks-list',
  templateUrl: './stocks-list.component.html',
  styleUrls: ['./stocks-list.component.scss']
})

export class StocksListComponent {
  displayedColumns: string[] = ['ticker', 'name', 'last', 'change', 'percent_change'];
  dataSource = ELEMENT_DATA;

  constructor() { }


}
