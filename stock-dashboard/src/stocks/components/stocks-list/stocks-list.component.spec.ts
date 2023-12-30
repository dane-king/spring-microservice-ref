import { routes } from './../../../app/app-routing.module';
import { StocksModule } from './../../stocks.module';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { StocksListComponent } from './stocks-list.component';
import { Router, Routes } from '@angular/router';

describe('StocksListComponent', () => {
  let component: StocksListComponent;
  let fixture: ComponentFixture<StocksListComponent>;
  let htmlBody:HTMLElement;
  let router:Router;
  let location:Location;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StocksListComponent],
      imports:[StocksModule, RouterTestingModule.withRoutes(routes)]
    })
    .compileComponents();

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StocksListComponent);
    component = fixture.componentInstance;
    htmlBody = fixture.debugElement.nativeElement;
    fixture.detectChanges();
  });

  it('should have render properly', () => {
    expect(fixture).toMatchSnapshot();
  });

  it('should have list of items', ()=>{
    expect(htmlBody.querySelector('#stock-list')).toBeTruthy();
  })
  it('should go to home if link is invalid', () => {

  });
  it('should go to stock card from ticker link', () => {

  });
});
function routes(routes: any): any {
  throw new Error('Function not implemented.');
}

