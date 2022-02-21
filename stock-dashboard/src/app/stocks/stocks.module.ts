import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StocksRoutingModule } from './stocks-routing.module';

// components
import * as fromComponents from './components';

import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [...fromComponents.components],
  imports: [
    CommonModule,
    MatCardModule,
    MatTableModule,
    StocksRoutingModule
  ],
  exports: [
    ...fromComponents.components,
  ]
})
export class StocksModule { }
