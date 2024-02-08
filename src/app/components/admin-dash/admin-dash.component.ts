import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/model/User';
import { UserPolicy } from 'src/app/model/UserPolicy';
import { UserPolicyService } from 'src/app/services/user-policy.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-dash',
  templateUrl: './admin-dash.component.html',
  styleUrls: ['./admin-dash.component.css']
})
export class AdminDashComponent implements OnInit
{
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

  ngOnInit(): void 
  {
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

  userPolicy:UserPolicy =
  {
    policyNo: 0,
    startDate: '',
    userId:0,
    policyId:0,
    
  }
  



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
 
  

//   getAllUsers()
// {
//   this.userService.getAllUsers().subscribe
//     (
//       (response2)=>
//       {
//         console.log(response2);
//         this.userDetails=response2;
//       },
//       (error)=>
//       {
//         console.log(error);
//       }
//     )
// }


// deleteUser(userId:any)
//   {
//     this.userService.deleteUser(userId).subscribe
//     (
//       (response2)=>
//     {
//       console.log(response2);
//       alert('User deleted successfully');
//       window.location.reload();

//     },
//     (error)=>
//     {
//       console.log(error);
//       alert('User deletion failed');
//       window.location.reload();

//     }
//     );
//   }


//   updateUser(RegFormData:any)
//    {
//       this.user.userId = RegFormData.form.value.userId;
//       this.user.fname = RegFormData.form.value.fname;
//       this.user.lname = RegFormData.form.value.lname;
//       this.user.dob = RegFormData.form.value.dob;
//       this.user.email = RegFormData.form.value.email;
//       this.user.mobNo = RegFormData.form.value.mobNo;
//       this.user.panNumber= RegFormData.form.value.panNumber;
//       this.user.salary= RegFormData.form.value.salary;
//       this.user.employerName = RegFormData.form.value.employerName;
//       this.user.employerType = this.employerTypeControl.value;
//       this.user.userCategory = this.userCategoryControl.value;
//       this.user.userType = this.userTypeControl.value;
//       this.user.address.addressLine = RegFormData.form.value.addressline;
//       this.user.address.city = RegFormData.form.value.city;
//       this.user.address.state = RegFormData.form.value.state;
//       this.user.address.pincode = RegFormData.form.value.pincode;
//       console.log(this.user);

      
//       let response = this.userService.updateUser(this.user);
//       response.subscribe
//       ( 
//         responseData => 
//         {
//           this.response = responseData; 
//           console.log(responseData);
//           alert('User updated successfully');
//           window.location.reload();

//         },
//         error =>
//         { 
//           console.log(error);
//           alert('User update failed');
//           window.location.reload();

//         }
//       );
//   }


//   getUserPolicyByUserId(userId:any)
//   {
//     this.userPolicyService.getUserPolicyByUserId(userId).subscribe
//     (
//       (response2)=>
//       {
//         console.log(response2);
//         this.userPolicyDetails=response2;
//       },
//       (error)=>
//       {
//         console.log(error);
//       }
//     )

//   }
//   deleteUserPolicy(policyNo:any)
//   {
//     this.userPolicyService.deleteUserPolicy(policyNo).subscribe
//     (
//       (response2)=>
//       {
//         console.log(response2);
//         alert('User policy deleted successfully');
//         window.location.reload();

//       },
//       (error)=>
//       {
//         console.log(error);
//         alert('User policy deletion failed');
//         window.location.reload();
//       }
//     );

//   }
//   getAllUserPolicies()

//   {
//     this.userPolicyService.getAllUserPolicies().subscribe
//     (
//       (response2)=>
//       {
//         console.log(response2);
//         this.userPolicyDetails=response2;
//       },
//       (error)=>
//       {
//         console.log(error);
//       }
//     )
//   }


// 
}
