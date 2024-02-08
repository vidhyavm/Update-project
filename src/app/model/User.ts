import { Address } from './Address';
import { UserPolicy } from './UserPolicy';

export interface User
{
    userId:any;
    fname:string;
    lname:string;
    password:string;
    email:string;
    mobNo:string;
    userType:any;
    employerType:any;
    employerName:any;
    userCategory:any;
    dob:any;
    salary:any;
    panNumber:string;
    address:Address;
}