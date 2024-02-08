import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolicyServicesService 
{
  constructor(private http:HttpClient) { }
  baseURL:string = 'http://localhost:8585/api/v1/';

  
  getAllPolicies()
  {
    return this.http.get(this.baseURL+"policies/getall",{responseType:'json'});
  }

  getPoliciesByType(policyType:any)
  {
    return this.http.get(this.baseURL+"policies/get/policy-type/"+policyType,{responseType:'json'});
  }

  deletePolicy(policyId:any): Observable<void> 
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.delete<void>(this.baseURL+'policies/delete/'+policyId,{headers,responseType:'text' as 'json'});
  }
  
  
  registerPolicy(policy:any)
{
  let tokenString = "Bearer "+localStorage.getItem("token");
  const headers =  new HttpHeaders().set("Authorization",tokenString);
  return this.http.post(this.baseURL+"policies/add",policy,{headers,responseType: 'text' as 'json'});
}

updatePolicy(policy:any)
{
  let tokenString = "Bearer "+localStorage.getItem("token");
  const headers =  new HttpHeaders().set("Authorization",tokenString);
  return this.http.put(this.baseURL+"policies/update",policy,{headers,responseType: 'text' as 'json'});
}
}
