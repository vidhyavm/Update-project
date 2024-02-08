import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/model/User';
import { UserPolicy } from 'src/app/model/UserPolicy';
import { UserPolicyService } from 'src/app/services/user-policy.service';

@Component({
  selector: 'app-yourpolicies',
  templateUrl: './yourpolicies.component.html',
  styleUrls: ['./yourpolicies.component.css']
})
export class YourpoliciesComponent  implements OnInit{

  userDetails:any;
  response:any;
  response2:any;
  userName:any;
  userPolicyDetails:any;
  employerTypeControl = new FormControl('',Validators.required);
  userTypeControl = new FormControl('',Validators.required);
  userCategoryControl = new FormControl('',Validators.required);

  constructor( private userPolicyService: UserPolicyService){}

  user: User = { 
    userId:0,
    fname: '', 
    lname: '',
    salary:'', 
    address:
    {
      addressId:'',
      addressLine: '',
      city: '',
      state: '',
      pincode: ''
    },
    password: '',
    email: '',
    mobNo: '',
    userType: '',
    employerType: '',
    employerName: '',
    userCategory: '',
    dob: '',
    panNumber: ''
  }
  userPolicy:UserPolicy=
  {
    policyNo: 0,
    startDate: '',
    userId:'',
    policyId:0,
   
  }
  

  ngOnInit(): void {
    
    this.userPolicyService.getUserPolicyByUserId(localStorage.getItem('userId')).subscribe
    (
      (response2)=>
      {
        console.log(response2);
        this.userPolicyDetails=response2;
      },
      (error2)=>
      {
        console.log(error2);
      }
    )  

   
  }



}
