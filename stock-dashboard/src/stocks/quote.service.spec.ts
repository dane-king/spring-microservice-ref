import { Stock } from './model/stock';
import { TestBed} from '@angular/core/testing';
import {HttpClientTestingModule,HttpTestingController } from '@angular/common/http/testing';
import { QuoteService } from './quote.service';
import StockQuote from '../mocks/stocks.json';

class MockStockQuote implements Stock{
  change: number;
  percent_change: number;
  constructor(public ticker: string, public name: string, public last: number){
    this.change = 0;
    this.percent_change = 0;
  }
}

describe('QuoteService', () => {
  let service: QuoteService;
  let httpMock: HttpTestingController;
  let url:string;
  let mockQuotes: Stock[] = [];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.inject(QuoteService)
    url=service.url;
    httpMock = TestBed.inject(HttpTestingController);
    mockQuotes = StockQuote.map(stock => new MockStockQuote(stock.symbol, stock.name, Number(stock.last)));
  });

  it('should get quotes from service', () => {
    service.getAllQuotes().subscribe((data:Stock[]) => {
      expect(data).toEqual(mockQuotes);
    });

    flushHttp(httpMock, url, mockQuotes);
  });
});


function flushHttp(httpMock: HttpTestingController, url: string, mockQuotes: Stock[]) {
  const req = httpMock.expectOne({
    method: 'GET',
    url: `${url}/quotes`,
  });

  req.flush(mockQuotes);
}

