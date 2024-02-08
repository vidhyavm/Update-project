import { Component } from '@angular/core';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { AuthRequest } from 'src/app/model/AuthRequest';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  response:any;
  token:any;

  authRequest: AuthRequest = new AuthRequest();
  constructor(private jwtService:JwtClientService){}


  ngOnInit(): void {}


   readFormData(formData:any)
   {
      this.authRequest.username = formData.form.value.username;
      this.authRequest.password = formData.form.value.password;
      this.jwtService.getGeneratedToken(this.authRequest).subscribe
      (
        (response:any)=>
        {
          console.log(response);
          this.jwtService.loginUser(response);
          if(response.userType ==='Admin')
          {
            window.location.href="/admin-dashboard";
            alert("Admin Login Successful");


          }
          if((response.userType ==='User'))
          {
            window.location.href="/user-dashboard";
            alert("User Login Successful");

          }

        },
        error=>
        {
          console.log(error);
          alert("Invalid Username or Password");
          window.location.reload();
        }
      )
   }

  public getAccessToken(authRequest:any)
  {
    let response =  this.jwtService.getGeneratedToken(authRequest);
    response.subscribe( (genToken)=> {  this.token = genToken ;console.log(genToken)});
  }


}
