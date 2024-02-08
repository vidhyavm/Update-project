import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule}  from '@angular/common/http' ;
import {FormsModule} from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatNativeDateModule} from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import { PolicySearchComponent } from './components/policy-search/policy-search.component';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { UserDashComponent } from './components/user-dash/user-dash.component';
import { GetAllUserPolicyComponent } from './components/get-all-user-policy/get-all-user-policy.component';
import { AdminProfileComponent } from './components/admin-profile/admin-profile.component';
import { UserdetailsComponent } from './components/userdetails/userdetails.component';
import { PolicyregComponent } from './components/policyreg/policyreg.component';
import { SearchpolicyComponent } from './components/searchpolicy/searchpolicy.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { YourpoliciesComponent } from './components/yourpolicies/yourpolicies.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    FooterComponent,
    HomepageComponent,
    PolicySearchComponent,
    AdminDashComponent,
    UserDashComponent,
    GetAllUserPolicyComponent,
  AdminProfileComponent,
  UserdetailsComponent,
  PolicyregComponent,
  SearchpolicyComponent,
  UserprofileComponent,
  YourpoliciesComponent
  

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NoopAnimationsModule,MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule,
    MatSelectModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
