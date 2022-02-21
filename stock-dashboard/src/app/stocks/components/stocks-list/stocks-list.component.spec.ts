import { StocksModule } from './../../stocks.module';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StocksListComponent } from './stocks-list.component';

describe('StocksListComponent', () => {
  let component: StocksListComponent;
  let fixture: ComponentFixture<StocksListComponent>;
  let htmlBody:HTMLElement

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StocksListComponent],
      imports:[StocksModule]
    })
    .compileComponents();

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StocksListComponent);
    component = fixture.componentInstance;
    htmlBody = fixture.debugElement.nativeElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have list of items', ()=>{
    expect(htmlBody.querySelector('#stock-list')).toBeTruthy();
  })
});
