import { StocksModule } from './stocks/stocks.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { fakeBackendProvider } from './_helpers/fake-backend';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { environment } from '@src/environments/environment';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    StocksModule
  ],
  providers: [
    !environment.production?fakeBackendProvider:[]
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
