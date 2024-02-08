import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/model/User';
import { UserPolicy } from 'src/app/model/UserPolicy';
import { UserPolicyService } from 'src/app/services/user-policy.service';


@Component({
  selector: 'app-get-all-user-policy',
  templateUrl: './get-all-user-policy.component.html',
  styleUrls: ['./get-all-user-policy.component.css']
})
export class GetAllUserPolicyComponent implements OnInit {
  ngOnInit(): void {

    this.getAllUserPolicies();
    
  }
  adminDetails:any;
  userDetails:any;
  response:any;
  response2:any;
  adminName:any;
  userPolicyDetails:any;
  employerTypeControl = new FormControl('',Validators.required);
  userTypeControl = new FormControl('',Validators.required);
  userCategoryControl = new FormControl('',Validators.required);
  policyTypeControl = new FormControl('',Validators.required);
  termPeriodControl = new FormControl('',Validators.required);

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

  userPolicy:UserPolicy =
  {
    policyNo: 0,
    startDate: '',
    userId:0,
    policyId:0,
    
  }

  constructor(private userPolicyService: UserPolicyService){}

  getAllUserPolicies()

  {
    this.userPolicyService.getAllUserPolicies().subscribe
    (
      (response2)=>
      {
        console.log(response2);
        this.userPolicyDetails=response2;
      },
      (error)=>
      {
        console.log(error);
      }
    )
  }
  deleteUserPolicy(policyNo:any)
  {
    this.userPolicyService.deleteUserPolicy(policyNo).subscribe
    (
      (response2)=>
      {
        console.log(response2);
        alert('User policy deleted successfully');
        window.location.reload();

      },
      (error)=>
      {
        console.log(error);
        alert('User policy deletion failed');
        window.location.reload();
      }
    );

  }
}
