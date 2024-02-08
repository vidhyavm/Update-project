import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Policy } from 'src/app/model/Policy';
import { UserPolicy } from 'src/app/model/UserPolicy';
import { PolicyServicesService } from 'src/app/services/policy-services.service';
import { UserPolicyService } from 'src/app/services/user-policy.service';

@Component({
  selector: 'app-policyreg',
  templateUrl: './policyreg.component.html',
  styleUrls: ['./policyreg.component.css']
})
export class PolicyregComponent {

  response:any;
  policyDetails:any;
  constructor(private policyService:PolicyServicesService ){}
  policy:Policy =
  { 
    policyId:0,
    policyName:'',
    policyType:'',
    company:'',
    policyDescription:'',
    termPeriod:'',
    amount:0,
    interest:0,
    termNo:0,
    maturityAmount:0,

  }

  userPolicy:UserPolicy=
  {
    policyNo: 0,
    startDate: '',
    userId:'',
    policyId:0,
   
  }
  policyTypeControl = new FormControl('',Validators.required);
  termPeriodControl = new FormControl('',Validators.required);





  isAdminLoggedIn()
  {
    let token=localStorage.getItem('token');
    if(token==undefined || token==='' || token==null)
    {
      return false;
    }
    else if(localStorage.getItem('userType')==='Admin')
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  // isUserLoggedIn()
  // {
  //   let token=localStorage.getItem('token');
  //   if(token==undefined || token==='' || token==null)
  //   {
  //     return false;
  //   }
  //   else if(localStorage.getItem('userType')==='User')
  //   {
  //     return true;
  //   }
  //   else
  //   {
  //     return false;
  //   }
  // }
  

  readPolicyRegFormData(formData:any)
  {
    this.policy.policyName = formData.form.value.policyName;
    this.policy.policyType = this.policyTypeControl.value;
    this.policy.termPeriod = this.termPeriodControl.value;
    this.policy.company = formData.form.value.company;
    this.policy.policyDescription = formData.form.value.description;
    this.policy.amount = formData.form.value.amount;
    this.policy.interest = formData.form.value.interest;
    this.policy.termNo = formData.form.value.termNo;
    if (this.policyTypeControl.value === "Retirement Plan" || this.policyTypeControl.value === "Children's Plan") 
    {
      let interest = formData.form.value.interest;
      let amount = formData.form.value.amount;
      let termNo = formData.form.value.termNo;
    
      if (this.termPeriodControl.value === "Monthly") {
        amount *= 12;
      } else if (this.termPeriodControl.value === "Quaterly") {
        amount *= 4;
      } else if (this.termPeriodControl.value === "Half-Yearly") {
        amount *= 2;
      }
    
      this.policy.maturityAmount = (((amount * interest) / 100) + amount) * termNo;
    } 
    else 
    {
      this.policy.maturityAmount = 0;
    }
    
    
    console.log(this.policy);


    let response = this.policyService.registerPolicy(this.policy);
    console.log(response);
    response.subscribe
    ( 
      responseData => 
      {
        this.response = responseData; 
        console.log(responseData);
        alert("Policy registration successful"); 
        window.location.reload();

      },
      error=>
      {
        console.log(error);
        alert("Policy registration failed");
        window.location.reload();

      }
    );

  }
}
