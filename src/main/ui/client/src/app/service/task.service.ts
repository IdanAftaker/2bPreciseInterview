import { Injectable } from '@angular/core';
import { Task } from "../model/task";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observer} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private _taskUrl: string = 'http://localhost:8080/tasks';
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };

  constructor(private http: HttpClient) { }

  async getTasksByOwnerPk(ownerPk: number) {
    let tasks;
    await this.http.get<Task[]>(this._taskUrl + `?ownerPk=${ownerPk}`, this.httpOptions)
      .toPromise().then((response => {
        console.log("inner", response);
        tasks = response;
        console.log("tasks", tasks)
      }));
    // @ts-ignore
    return tasks;
  }
}
