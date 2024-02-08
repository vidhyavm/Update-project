package com.hexaware.policymanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.policymanagement.dto.PolicyDTO;
import com.hexaware.policymanagement.entity.Policy;
import com.hexaware.policymanagement.exception.PolicyNotFoundException;
import com.hexaware.policymanagement.repository.PolicyRepository;
/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: Policy Service Implementaion
 */
/* Author:Devanshu
 * @UpdatedOn:-16-11-2023
 * Description: Added Exception and logger
 */
@Service
public class PolicyServicesImp implements IPolicyServices {

    private static final Logger logger = LoggerFactory.getLogger(PolicyServicesImp.class);

    @Autowired
    PolicyRepository policyrepo;

    @Override
    public Policy createPolicy(PolicyDTO policyDTO) 
    {
        try 
        {
            Policy policy = new Policy();
            policy.setPolicyName(policyDTO.getPolicyName());
            policy.setPolicyType(policyDTO.getPolicyType());
            policy.setAmount(policyDTO.getAmount());
            policy.setCompany(policyDTO.getCompany());
            policy.setPolicyDescription(policyDTO.getPolicyDescription());
            policy.setInterest(policyDTO.getInterest());
            policy.setTermPeriod(policyDTO.getTermPeriod());
            policy.setTermNo(policyDTO.getTermNo());
    		policy.setMaturityAmount(policyDTO.getMaturityAmount());


            Policy createdPolicy = policyrepo.save(policy);

            logger.info("Policy created successfully: {}", createdPolicy);

            return createdPolicy;
        } 
        catch (Exception e) 
        {
            logger.error("Error creating Policy", e);
            throw new RuntimeException("Error creating Policy", e);
        }
    }

    @Override
    public Policy updatePolicy(PolicyDTO policyDTO) {
        try 
        {
            if (!policyrepo.existsById(policyDTO.getPolicyId())) 
            {
                throw new PolicyNotFoundException("Policy not found with ID: " + policyDTO.getPolicyId());
            }

            Policy policy = new Policy();
            policy.setPolicyId(policyDTO.getPolicyId());
            policy.setPolicyName(policyDTO.getPolicyName());
            policy.setPolicyType(policyDTO.getPolicyType());
            policy.setAmount(policyDTO.getAmount());
            policy.setCompany(policyDTO.getCompany());
            policy.setMaturityAmount(policyDTO.getMaturityAmount());
            policy.setPolicyDescription(policyDTO.getPolicyDescription());
            policy.setInterest(policyDTO.getInterest());
            policy.setTermPeriod(policyDTO.getTermPeriod());
            policy.setTermNo(policyDTO.getTermNo());
            policy.setMaturityAmount(policyDTO.getMaturityAmount());
            Policy updatedPolicy = policyrepo.save(policy);

            logger.info("Policy updated successfully: {}", updatedPolicy);

            return updatedPolicy;
        } 
        
        catch (Exception e) 
        {
            logger.error("Error updating Policy", e);
            throw new RuntimeException("Error updating Policy", e);
        }
    }

    @Transactional
    @Override
    public void deleteByPolicyId(long policyId) 
    {
        try 
        {
            if (!policyrepo.existsById(policyId)) 
            {
                throw new PolicyNotFoundException("Policy not found with ID: " + policyId);
            }

            policyrepo.deleteById(policyId);

            logger.info("Policy deleted successfully with ID: {}", policyId);
        } 
         
        catch (Exception e) 
        {
            logger.error("Error deleting Policy", e);
            throw new RuntimeException("Error deleting Policy", e);
        }
    }

    @Override
    public List<Policy> getPolicyByPolicyType(String policyType) 
    {
        try 
        {
            List<Policy> policies = policyrepo.findByPolicyType(policyType);

            logger.info("Retrieved Policies by Policy Type successfully: {}", policies);

            return policies;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting Policies by Policy Type", e);
            throw new RuntimeException("Error getting Policies by Policy Type", e);
        }
    }

    @Override
    public List<Policy> getPolicyByCompany(String company) 
    {
        try 
        {
            List<Policy> policies = policyrepo.findByCompany(company);

            logger.info("Retrieved Policies by Company successfully: {}", policies);

            return policies;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting Policies by Company", e);
            throw new RuntimeException("Error getting Policies by Company", e);
        }
    }

    @Override
    public List<Policy> getAllPolicy() 
    {
        try 
        {
            List<Policy> policies = policyrepo.findAll();

            logger.info("Retrieved all Policies successfully: {}", policies);

            return policies;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting all Policies", e);
            throw new RuntimeException("Error getting all Policies", e);
        }
    }

    @Override
    public List<Policy> getByAmountLessThan(double amount) 
    {
        try 
        {
            List<Policy> policies = policyrepo.findByAmountLessThan(amount);

            logger.info("Retrieved Policies by Amount Less Than successfully: {}", policies);

            return policies;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting Policies by Amount Less Than", e);
            throw new RuntimeException("Error getting Policies by Amount Less Than", e);
        }
    }

    @Override
    public List<Policy> getByAmountGreaterThan(double amount) 
    {
        try 
        {
            List<Policy> policies = policyrepo.findByAmountGreaterThan(amount);

            logger.info("Retrieved Policies by Amount Greater Than successfully: {}", policies);

            return policies;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting Policies by Amount Greater Than", e);
            throw new RuntimeException("Error getting Policies by Amount Greater Than", e);
        }
    }
}
