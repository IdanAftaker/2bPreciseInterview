import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {


  constructor(public employeeService: EmployeeService, private router: Router) {
  }

  ngOnInit() { }

  async viewProfile(employee: Employee) {
    await this.router.navigate([`employees/${employee.pk}`])
  }
}
