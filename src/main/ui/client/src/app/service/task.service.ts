import { Injectable } from '@angular/core';
import { Task } from "../model/task";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TaskRequestDTO} from "../model/dto/task-request-dto";
import {MatSnackBar} from "@angular/material/snack-bar";

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private taskUrl: string = 'http://localhost:8080/tasks';
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };
  tasks: Task[] | undefined;

  constructor(private http: HttpClient, private snackBar: MatSnackBar) {
  }

  async getTasksByOwnerPk(ownerPk: number) {
    let tasks;
    await this.http.get<Task[]>(this.taskUrl + `?ownerPk=${ownerPk}`, this.httpOptions)
      .toPromise().then((response => {
        tasks = response;
      }));
    return tasks;
  }

  saveTask(assignDate: Date, dueDate: Date, description: string, ownerPk: number) {
    const requestDTO = new TaskRequestDTO(assignDate, dueDate, description, ownerPk);
    this.http.post(this.taskUrl, requestDTO, this.httpOptions).subscribe(response => {
      this.snackBar.open('Task saved successfully.', 'Dismiss', {
        duration: 3000,
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
        panelClass: ['mat-toolbar', 'mat-accent']
      });
      return response;
    });
  }

  async getTasksByEmployeePk(employeePk: number) {
    return await this.getTasks(employeePk);
  }

  async getTasks(employeePk: number) {
    await this.http.get<Task[]>(this.taskUrl + `?ownerPk=${employeePk}`, this.httpOptions)
      .toPromise().then((response) => this.tasks = response);


    return this.tasks;
  }
}
