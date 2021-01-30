import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { GestionventemateriauxinfoSharedModule } from 'app/shared/shared.module';

import { LogsComponent } from './logs.component';

import { logsRoute } from './logs.route';

@NgModule({
  imports: [GestionventemateriauxinfoSharedModule, RouterModule.forChild([logsRoute])],
  declarations: [LogsComponent],
})
export class LogsModule {}
