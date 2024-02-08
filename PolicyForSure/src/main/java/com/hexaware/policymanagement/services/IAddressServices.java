package com.hexaware.policymanagement.services;

import java.util.List;

import com.hexaware.policymanagement.dto.AddressDTO;
import com.hexaware.policymanagement.entity.Address;
/* Author:Devanshu/Vidhyamalathi
 * @CreatedOn:-14-11-2023
 * Description: Address Service Interface
 */
public interface IAddressServices 
{

public Address createAddress(AddressDTO addressDTO);
public Address updateAddress(AddressDTO addressDTO);
public void deleteByAddressId(long addressId);
public List<Address> getByState(String state);
public List<Address> getByCity(String city);

public List<Address> getAllAddress();

}

