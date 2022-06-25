import { NgModule } from '@angular/core';
import { MaterialModule } from '../material-module';
import { RequestPageComponent } from './request-page/request-page.component';

@NgModule({
  declarations: [RequestPageComponent],
  imports: [ MaterialModule],
  exports: [RequestPageComponent],
  providers: []
})

export class RequestModule { }
