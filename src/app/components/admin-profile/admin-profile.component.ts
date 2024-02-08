import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit{

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

  constructor(private userService: UserService){}
  
  ngOnInit(): void {
    this.userService.getUserById(localStorage.getItem('userId')).subscribe
    (
      (response)=>
      {
        console.log(response);
        this.adminDetails=Array.of(response);
      },
      (error)=>
      {
        console.log(error);
      }
    )
    this.adminName = localStorage.getItem('userName');
  }


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

  updateUser(RegFormData:any)
     {
        this.user.userId = RegFormData.form.value.userId;
        this.user.fname = RegFormData.form.value.fname;
        this.user.lname = RegFormData.form.value.lname;
        this.user.dob = RegFormData.form.value.dob;
        this.user.email = RegFormData.form.value.email;
        this.user.mobNo = RegFormData.form.value.mobNo;
        this.user.panNumber= RegFormData.form.value.panNumber;
        this.user.salary= RegFormData.form.value.salary;
        this.user.employerName = RegFormData.form.value.employerName;
        this.user.employerType = this.employerTypeControl.value;
        this.user.userCategory = this.userCategoryControl.value;
        this.user.userType = this.userTypeControl.value;
        this.user.address.addressLine = RegFormData.form.value.addressline;
        this.user.address.city = RegFormData.form.value.city;
        this.user.address.state = RegFormData.form.value.state;
        this.user.address.pincode = RegFormData.form.value.pincode;
        console.log(this.user);
  
        
        let response = this.userService.updateUser(this.user);
        response.subscribe
        ( 
          responseData => 
          {
            this.response = responseData; 
            console.log(responseData);
            alert('User updated successfully');
            window.location.reload();
  
          },
          error =>
          { 
            console.log(error);
            alert('User update failed');
            window.location.reload();
  
          }
        );
    }

}
