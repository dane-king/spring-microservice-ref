import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StocksRoutingModule } from './stocks-routing.module';

// components
import * as fromComponents from './components';


@NgModule({
  declarations: [...fromComponents.components],
  imports: [
    CommonModule,
    StocksRoutingModule
  ],
  exports: [
    ...fromComponents.components,
  ]
})
export class StocksModule { }
