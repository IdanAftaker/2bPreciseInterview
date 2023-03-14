import { Injectable } from '@angular/core';
import {Employee} from "../model/employee";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ReportRequestDTO} from "../model/dto/report-request-dto";
import {Report} from "../model/report";
import {EmployeeService} from "./employee.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private reportUrl: string = 'http://localhost:8080/reports';
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };

  ownerPk: number
  private reports: Report[] | undefined;
  employeeService: EmployeeService

  constructor( private http: HttpClient, employeeService: EmployeeService, private snackBar: MatSnackBar) {
    this.employeeService = employeeService;
  }

  saveReport(report: string, employee: Employee) {
    console.log(report)
    const requestDTO = new ReportRequestDTO(report, new Date(), employee.pk, employee.managerPk)
    this.http.post(this.reportUrl, requestDTO, this.httpOptions).subscribe(response => {
      this.snackBar.open('Report sent to manager successfully.', 'Dismiss', {
        duration: 3000,
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
        panelClass: ['mat-toolbar', 'mat-accent']
      });
      return response
    });

  }
  async getReportsByEmployeePk(employeePk: number) {
    return await this.getReports(employeePk);
  }

  async getReports(employeePk?: number) {
    await this.http.get<Report[]>(this.reportUrl + `?ownerPk=${employeePk!}`, this.httpOptions)
      .toPromise().then((response) => {
        this.reports = response;
    });
    return this.reports;
  }

  getReporterName(reporterPk: number) {
    let employee = this.employeeService.getEmployee(reporterPk);
    return `${employee?.firstName} ${employee?.lastName}`;
  }
}
