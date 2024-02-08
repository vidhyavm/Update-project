import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  baseURL:string = 'http://localhost:8585/api/v1/';

  registerUser(requestBody:any)
    {
      return this.http.post(this.baseURL+"users/add",requestBody,{responseType:'json'})
    }
  getAllUsers()
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.get(this.baseURL+"users/getall",{headers,responseType:'json'});
  }
  deleteUser(userId:any): Observable<void> 
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.delete<void>(this.baseURL+'users/delete/'+userId,{headers,responseType:'json'});
  }
  updateUser(user:any)
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.put(this.baseURL+"users/update",user,{headers,responseType:'json'});
  }
  getUserById(userId:any)
  {
    let tokenString = "Bearer "+localStorage.getItem("token");
    const headers =  new HttpHeaders().set("Authorization",tokenString);
    return this.http.get(this.baseURL+"users/get/id/"+userId,{headers,responseType:'json'});
  }

  sendMailRegistration(userId:any)
  {
    console.log(userId);
    return this.http.get<boolean>(this.baseURL+"users/sendmailregistration/"+userId)
  }
}
