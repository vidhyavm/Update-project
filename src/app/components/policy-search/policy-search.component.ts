import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Policy } from 'src/app/model/Policy';
import { UserPolicy } from 'src/app/model/UserPolicy';
import { PolicyServicesService } from 'src/app/services/policy-services.service';
import { UserPolicyService } from 'src/app/services/user-policy.service';

@Component({
  selector: 'app-policy-search',
  templateUrl: './policy-search.component.html',
  styleUrls: ['./policy-search.component.css']
})
export class PolicySearchComponent implements OnInit
{
  response:any;
  policyDetails:any;
  constructor(private policyService:PolicyServicesService, private userPolicyService: UserPolicyService,
               private router: Router ){}
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



  ngOnInit(): void 
  {
    this.policyService.getAllPolicies().subscribe
    (
      (response)=>
      {
        console.log(response);
        this.policyDetails=response;
      },
      (error)=>
      {
        console.log(error);
      }
    )

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
  isUserLoggedIn()
  {
    let token=localStorage.getItem('token');
    if(token==undefined || token==='' || token==null)
    {
      return false;
    }
    else if(localStorage.getItem('userType')==='User')
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  deletePolicy(policyId:any)
  {
    this.policyService.deletePolicy(policyId).subscribe
    (
      (response)=>
    {
      console.log(response);
      alert('Policy deleted successfully');
      window.location.reload();

    },
    (error)=>
    {
      console.log(error);
      alert('Policy deletion failed');
      window.location.reload();

    }
    )
  }


  updateFormData(formData:any)
  {
    this.policy.policyId = formData.form.value.policyId;
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
    


    let response = this.policyService.updatePolicy(this.policy);
    console.log(response);
    response.subscribe
    ( responseData => 
      {
        this.response = responseData; 
        console.log(responseData);
        alert("Policy update successful");
        window.location.reload();

      },
      error=>
      {
        console.log(error);
        alert("Policy update failed");
        window.location.reload();

      });

  }
  // sortPolicies(sortType:any)
  // {
  //   if(sortType.target.value==='1')
  //   {
  //     this.policyDetails.sort((a:any, b:any) => 
  //     (a.amount > b.amount ? 1 : b.amount > a.amount ? -1 : 0));
  //       console.log(this.policyDetails);

  //   }
  //   else
  //   {
  //     this.policyDetails.sort((a:any, b:any) => 
  //     (a.amount < b.amount ? 1 : b.amount < a.amount ? -1 : 0));
  //       console.log(this.policyDetails);

  //   }
  // }

  // getPoliciesByType(policyType:any)
  // {
  //   if(policyType.target.value==='Get All')
  //   {
  //     this.policyService.getAllPolicies().subscribe
  //   (
  //     (response)=>
  //     {
  //       console.log(response);
  //       this.policyDetails=response;
  //     },
  //     (error)=>
  //     {
  //       console.log(error);
  //     }
  //   )

  //   }

  //   this.policyService.getPoliciesByType(policyType.target.value).subscribe
  //   (
  //     (response)=>
  //     {
  //       console.log(response);
  //       this.policyDetails=response;
  //     },
  //     (error)=>
  //     {
  //       console.log(error);
  //     }
  //   )
  // }

  buyPolicy(policyId:any)
  {
    const now = new Date();
    this.userPolicy.startDate = now;
    this.userPolicy.policyId = policyId;
    this.userPolicy.userId = localStorage.getItem('userId');
    
    let response = this.userPolicyService.addUserPolicies(this.userPolicy);
    response.subscribe
    ( 
      responseData => 
      {
        this.response = responseData; 
        console.log(responseData);
        alert("Policy added to your account. Your Policy will start from today.");
        this.router.navigate(['user-dashboard']);
      },
      error=>
      {
        console.log(error);
        alert("User policy buying failed");
        window.location.reload();


      }
    );


  }
  handleSearchChange(event: any) {
    const selectedValue = event.target.value.split(':');

    if (selectedValue[0] === 'Sort') {
      this.sortPolicies(selectedValue[1]);
    } else if (selectedValue[0] === 'PolicyType') {
      this.getPoliciesByType(selectedValue[1]);
    }
  }

  sortPolicies(sortType: string) {
    // Sorting logic here
    if (sortType === '1') {
      this.policyDetails.sort((a: any, b: any) =>
        (a.amount > b.amount ? 1 : b.amount > a.amount ? -1 : 0));
      console.log(this.policyDetails);
    } else if (sortType === '2') {
      this.policyDetails.sort((a: any, b: any) =>
        (a.amount < b.amount ? 1 : b.amount < a.amount ? -1 : 0));
      console.log(this.policyDetails);
    }
  }

  getPoliciesByType(policyType: string) {
    // Filtering by policy type logic here
    if (policyType === 'Get All') {
      this.policyService.getAllPolicies().subscribe(
        (response) => {
          console.log(response);
          this.policyDetails = response;
        },
        (error) => {
          console.log(error);
        }
      );
    } else {
      this.policyService.getPoliciesByType(policyType).subscribe(
        (response) => {
          console.log(response);
          this.policyDetails = response;
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }

}
