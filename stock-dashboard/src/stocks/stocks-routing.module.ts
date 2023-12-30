import { StocksListComponent } from './components/stocks-list/stocks-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { components, StockCardComponent } from './components';
const routes: Routes = [
  {
    path: "",
    component: StocksListComponent
  },
  { path: ':id', component: StockCardComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StocksRoutingModule { }
