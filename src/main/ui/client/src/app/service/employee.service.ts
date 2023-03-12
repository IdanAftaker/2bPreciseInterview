import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../model/employee';

@Injectable()
export class EmployeeService {

  private _employees: Employee[] = [];


  private _employeesUrl: string = 'http://localhost:8080/employees';
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };

  constructor(private http: HttpClient) {
    this.findAll();
  }

  public get employees(){
    return this._employees;
  }

  public get employeesUrl(){
    return this._employeesUrl;
  }

  public set employees(list: Employee[]){
    this._employees = list;
  }

  public getEmployee(id: number) {
    return this.employees?.find(x => x.pk == id) || null;
  }

  public findAll(): void {
     this.http.get<Employee[]>(this._employeesUrl, this.httpOptions).toPromise().then(x => {
       if(x) this.employees = x;
     });
  }
}
