import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { EmployeeService } from './service/employee.service';
import { EmployeeProfileComponent } from './component/employee-profile/employee-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
