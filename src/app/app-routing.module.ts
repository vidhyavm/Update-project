import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginComponent } from './components/login/login.component';
import { UserDashComponent } from './components/user-dash/user-dash.component';
import { RegisterComponent } from './components/register/register.component';
import { PolicySearchComponent } from './components/policy-search/policy-search.component';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { AuthGuard } from './services/auth.guard';
import { AdminAuthGuard } from './services/admin-auth.guard';
import { AdminProfileComponent } from './components/admin-profile/admin-profile.component';
import { GetAllUserPolicyComponent } from './components/get-all-user-policy/get-all-user-policy.component';
import { UserdetailsComponent } from './components/userdetails/userdetails.component';
import { PolicyregComponent } from './components/policyreg/policyreg.component';
import { SearchpolicyComponent } from './components/searchpolicy/searchpolicy.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { YourpoliciesComponent } from './components/yourpolicies/yourpolicies.component';

const routes: Routes = [

  {
    path:'',
    component:HomepageComponent,
    pathMatch:'full'
  },
  {
    path:'login',
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:'user-dashboard',
    component:UserDashComponent,
    children:[
      {path:'userprofile',component:UserprofileComponent},
      {path:'yourpolicy',component:YourpoliciesComponent}
    ],
    canActivate: [AuthGuard]
  },
  {
    path:'register-user',
    component:RegisterComponent,
    pathMatch:'full'
  },
  
  {
    path:'admin-dashboard',
    component:AdminDashComponent,
    children:[
      { path:'policyreg',component:PolicyregComponent},
      {path:'policysearch',component:PolicySearchComponent},
      {path:'admininfo',component:AdminProfileComponent},
      {path:'userdetails',component:UserdetailsComponent},
      {path:'getuserpolicy',component:GetAllUserPolicyComponent}
    ],
    canActivate: [AdminAuthGuard]
  },
  {
    path:'searchpolicy',
    component:SearchpolicyComponent,
    pathMatch:'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
