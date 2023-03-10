import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from "./component/employee-list/employee-list.component";
import { EmployeeProfileComponent } from "./component/employee-profile/employee-profile.component";

const routes: Routes = [
  { path: 'employees/:id', component: EmployeeProfileComponent },
  { path: 'employees', component: EmployeeListComponent },
  { path: '', redirectTo: '/employees', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
