import { components } from './../stocks/components/index';
import * as fromStocks from '../stocks/components';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'stocks', pathMatch: 'full' },
  {
    path: 'stocks',
    loadChildren: () => import('../stocks/stocks.module').then(m => m.StocksModule)
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
