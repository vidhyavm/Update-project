import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { User } from '../../model/User';
import { UserService } from '../../services/user.service';
import { UserPolicyService } from '../../services/user-policy.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit{

  userDetails:any;
  ngOnInit(): void {
    
    this.getAllUsers();
    
  }

  adminDetails:any;
  response:any;
  response2:any;
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

  constructor(private userService: UserService, private userPolicyService: UserPolicyService){}

  deleteUser(userId:any)
  {
    this.userService.deleteUser(userId).subscribe
    (
      (response2)=>
    {
      console.log(response2);
      alert('User deleted successfully');
      window.location.reload();

    },
    (error)=>
    {
      console.log(error);
      alert('User deletion failed');
      window.location.reload();

    }
    );
  }

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
  getAllUsers()
{
  this.userService.getAllUsers().subscribe
    (
      (response2)=>
      {
        console.log(response2);
        this.userDetails=response2;
      },
      (error)=>
      {
        console.log(error);
      }
    )
}


  getUserPolicyByUserId(userId:any)
  {
    this.userPolicyService.getUserPolicyByUserId(userId).subscribe
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
}


