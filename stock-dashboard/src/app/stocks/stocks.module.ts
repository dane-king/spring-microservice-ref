import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// components
import * as fromComponents from './components';

import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';


@NgModule({
  declarations: [...fromComponents.components],
  imports: [
    CommonModule,
    MatCardModule,
    MatTableModule
  ],
  exports: [
    ...fromComponents.components,
  ]
})
export class StocksModule { }
