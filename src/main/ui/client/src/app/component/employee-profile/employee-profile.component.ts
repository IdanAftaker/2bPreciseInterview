import { Component } from '@angular/core';
import { Employee } from '../../model/employee';
import {ActivatedRoute} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent {
  employee: Employee | undefined;
  manager: Employee | undefined;
  subordinates: Employee[] | undefined;
  private _employeesUrl: string = 'http://localhost:8080/employees';


  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };

  constructor(private route: ActivatedRoute, private http: HttpClient) {
    const employeeId = this.route.snapshot.params['id']
    this.http.get<Employee>(this._employeesUrl + `/${employeeId}`, this.httpOptions)
      .subscribe((response) => {
        this.employee = response
        if (!(this.employee.managerPk === null)) {
          this.http.get<Employee>(this._employeesUrl + `/${this.employee?.managerPk}`, this.httpOptions)
            .subscribe((response) => this.manager = response)
        }
        this.http.get<Employee[]>(this._employeesUrl + `/${employeeId}/subordinates`, this.httpOptions)
          .subscribe((response) => this.subordinates = response)
        console.log("subordinates", this.subordinates);
      });


  }
}
