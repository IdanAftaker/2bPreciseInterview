import { Component } from '@angular/core';
import { Employee } from '../../model/employee';
import {ActivatedRoute} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Router } from '@angular/router';
import {MatDialog} from "@angular/material/dialog";
import {ReportDialogComponent} from "../report-dialog/report-dialog.component";
import {TaskDialogComponent} from "../task-dialog/task-dialog.component";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent {
  private employeesUrl: string = 'http://localhost:8080/employees';
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };

  employee: Employee | undefined;
  manager: Employee | undefined;
  subordinates: Employee[] | undefined;

  constructor(public dialog: MatDialog,private route: ActivatedRoute, private http: HttpClient,
              private router: Router) {
    const employeeId = this.route.snapshot.params['id']
    this.http.get<Employee>(this.employeesUrl + `/${employeeId}`, this.httpOptions)
      .subscribe((response) => {
        this.employee = response
        if (!(this.employee.managerPk === null)) {
          // get manager
          this.http.get<Employee>(this.employeesUrl + `/${this.employee?.managerPk}`, this.httpOptions)
            .subscribe((response) => this.manager = response)
        }
        // get subordinates
        this.http.get<Employee[]>(this.employeesUrl + `/${employeeId}/subordinates`, this.httpOptions)
          .subscribe((response) => this.subordinates = response)
      });
  }

  async viewEmployees() {
    await this.router.navigate(['employees']);
  }

  assignTask(subordinatePk: number | undefined) {
    this.dialog.open(TaskDialogComponent, {data:{subordinatePk: subordinatePk}})
  }

  reportToManager() {
    this.dialog.open(ReportDialogComponent, {data:{employee: this.employee}})
  }
}
