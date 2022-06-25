import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing/app-routing.module';


import { AppComponent } from './app.component';
import { MaterialModule } from './components/material-module';
import { Interceptor } from './interceptors/intercept.service';
import { NavbarNonAuthComponent } from './components/navbar/navbar-non-auth/navbar-non-auth.component';
import { SharedModule } from './components/shared/shared.module';
import { MatDialogModule } from '@angular/material/dialog';
import { RequestModule } from './components/request/request.module';

@NgModule({
  declarations: [
    AppComponent,
    NavbarNonAuthComponent,
  ],
  imports: [
    AppRoutingModule,
    MaterialModule,
    MatDialogModule,
    RequestModule,
    SharedModule,
    BrowserModule,
    ToastrModule.forRoot(),

  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}],
  bootstrap: [AppComponent],
})
export class AppModule { }
