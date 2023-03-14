import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { EmployeeService } from './service/employee.service';
import { EmployeeProfileComponent } from './component/employee-profile/employee-profile.component';
import { ReportDialogComponent } from './component/report-dialog/report-dialog.component';
import {TaskService} from "./service/task.service";
import {ReportService} from "./service/report.service";
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { TaskDialogComponent } from './component/task-dialog/task-dialog.component';
import { ReportListComponent } from './component/report-list/report-list.component';
import { TaskListComponent } from './component/task-list/task-list.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatNativeDateModule} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeProfileComponent,
    ReportDialogComponent,
    TaskDialogComponent,
    ReportListComponent,
    TaskListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatSnackBarModule
  ],
  providers: [EmployeeService, TaskService, ReportService, MatDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
