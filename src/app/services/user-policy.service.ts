import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserPolicyService 
{

  constructor(private http:HttpClient) { }
  baseURL:string = 'http://localhost:8585/api/v1/';

  getUserPolicyByUserId(userId:any)
  {
    console.log(userId);
    let tokenString = "Bearer "+localStorage.getItem("token");
    console.log(tokenString);
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    console.log(headers);
    return this.http.get(this.baseURL+"userpolicies/get/userId/"+userId,{headers,responseType:'json'});

  }
  deleteUserPolicy(policyNo:any)
  {
    console.log(policyNo);
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.delete(this.baseURL+"userpolicies/delete/"+policyNo,{headers,responseType:'json'});
    
  }
  getAllUserPolicies()
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.get(this.baseURL+"userpolicies/getall",{headers,responseType:'json'});

  }
  updateUserPolicies(formdata:any)
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.put(this.baseURL+"userpolicies/update",formdata,{headers,responseType:'json'});
  }
  addUserPolicies(formdata:any)
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.post(this.baseURL+"userpolicies/add",formdata,{headers,responseType:'json'});
  }
}
