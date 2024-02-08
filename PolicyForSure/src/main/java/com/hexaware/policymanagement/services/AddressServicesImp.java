package com.hexaware.policymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.policymanagement.dto.AddressDTO;
import com.hexaware.policymanagement.entity.Address;
import com.hexaware.policymanagement.exception.AddressNotFoundException;
import com.hexaware.policymanagement.repository.AddressRepository;
/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: Address Service Implementaion
 */
/* Author:Devanshu
 * @UpdatedOn:-16-11-2023
 * Description: Added Exception and Logger
 */
@Service
public class AddressServicesImp implements IAddressServices {

    private static final Logger logger = LoggerFactory.getLogger(AddressServicesImp.class);

    @Autowired
    AddressRepository addressrepo;

    @Override
    public Address createAddress(AddressDTO addressDTO) 
    {
        try 
        {
            Address address = new Address();
            address.setAddressLine(addressDTO.getAddressLine());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setPincode(addressDTO.getPincode());

            Address createdAddress = addressrepo.save(address);

            logger.info("Address created successfully: {}", createdAddress);

            return createdAddress;
        } 
        catch (Exception e) 
        {
            logger.error("Error creating address", e);
            throw new RuntimeException("Error creating address", e);
        }
    }

    @Override
    public Address updateAddress(AddressDTO addressDTO) 
    {
        try 
        {
            if (!addressrepo.existsById(addressDTO.getAddressId())) 
            {
                throw new AddressNotFoundException("Address not found with ID: " + addressDTO.getAddressId());
            }

            Address address = new Address();
            address.setAddressId(addressDTO.getAddressId());
            address.setAddressLine(addressDTO.getAddressLine());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setPincode(addressDTO.getPincode());

            Address updatedAddress = addressrepo.save(address);

            logger.info("Address updated successfully: {}", updatedAddress);

            return updatedAddress;
        } 
        catch (Exception e) 
        {
            logger.error("Error updating address", e);
            throw new RuntimeException("Error updating address", e);
        }
    }

    @Transactional
    @Override
    public void deleteByAddressId(long addressId) 
    {
        try 
        {
            if (!addressrepo.existsById(addressId)) 
            {
                throw new AddressNotFoundException("Address not found with ID: " + addressId);
            }

            addressrepo.deleteById(addressId);

            logger.info("Address deleted successfully with ID: {}", addressId);
        } 
        catch (Exception e) 
        {
            logger.error("Error deleting address", e);
            throw new RuntimeException("Error deleting address", e);
        }
    }

    @Override
    public List<Address> getAllAddress() 
    {
        try 
        {
            List<Address> addresses = addressrepo.findAll();

            logger.info("Retrieved all addresses successfully: {}", addresses);

            return addresses;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting all addresses", e);
            throw new RuntimeException("Error getting all addresses", e);
        }
    }

    @Override
    public List<Address> getByState(String state) 
    {
        try 
        {
            List<Address> addresses = addressrepo.findByState(state);

            logger.info("Retrieved addresses by state '{}' successfully: {}", state, addresses);

            return addresses;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting addresses by state", e);
            throw new RuntimeException("Error getting addresses by state", e);
        }
    }

    @Override
    public List<Address> getByCity(String city) 
    {
        try 
        {
            List<Address> addresses = addressrepo.findByCity(city);

            logger.info("Retrieved addresses by city '{}' successfully: {}", city, addresses);

            return addresses;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting addresses by city", e);
            throw new RuntimeException("Error getting addresses by city", e);
        }
    }
}
