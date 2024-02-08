package com.hexaware.policymanagement.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.policymanagement.dto.UserPolicyDTO;
import com.hexaware.policymanagement.entity.Policy;
import com.hexaware.policymanagement.entity.PolicyPayment;
import com.hexaware.policymanagement.entity.User;
import com.hexaware.policymanagement.entity.UserPolicy;
import com.hexaware.policymanagement.exception.UserPolicyNotFoundException;
import com.hexaware.policymanagement.repository.PolicyPaymentRepository;
import com.hexaware.policymanagement.repository.PolicyRepository;
import com.hexaware.policymanagement.repository.UserPolicyRepository;
import com.hexaware.policymanagement.repository.UserRepository;
/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: UserPolicy Service Implementaion
 */
/* Author:Devanshu
 * @UpdatedOn:-16-11-2023
 * Description: Added Exception and logger
 */
@Service
public class UserPolicyServicesImp implements IUserPolicyServices {

    private static final Logger logger = LoggerFactory.getLogger(UserPolicyServicesImp.class);

    @Autowired
    UserPolicyRepository userpolicyrepo;
    
    @Autowired
    UserRepository userRepo;
    
    @Autowired
    PolicyRepository policyRepo;
    
    @Autowired
    PolicyPaymentRepository paymentRepo;

    @Override
    public UserPolicy createUserPolicy(UserPolicyDTO userpolicyDTO) {
        try {
        	User user = new User();
        	user = userRepo.findByUserId(userpolicyDTO.getUserId());
        	Policy policy = new Policy();
        	policy = policyRepo.findByPolicyId(userpolicyDTO.getPolicyId());
        	
        	 boolean hasActivePolicy = userpolicyrepo.existsByUserAndPolicyAndEndDateAfter(user, policy, LocalDate.now());
             if (hasActivePolicy) {
                 throw new IllegalStateException("User already has an active policy for the specified policy type.");
             }
             
        	
        	UserPolicy userpolicy = new UserPolicy();
        	PolicyPayment payment = new PolicyPayment();
        	
        	payment.setAmount(policy.getAmount());
        	payment.setBank("HDFC Bank");
        	payment.setPaymentStatus("Completed");
        	payment.setPaymentDate(LocalDate.now());
        	
        	
            userpolicy.setStartDate(userpolicyDTO.getStartDate());
            int addYear = (int) policy.getTermNo();
            LocalDate endDate = userpolicyDTO.getStartDate().plusYears(addYear);
            userpolicy.setEndDate(endDate);
            userpolicy.setPolicy(policy);
            userpolicy.setUser(user);
            payment.setUserPolicy(userpolicy);
            
            paymentRepo.save(payment);

            logger.info("User Policy created successfully: {}", userpolicy);

            return userpolicy;
        } catch (Exception e) {
            logger.error("Error creating User Policy", e);
            throw new RuntimeException("Error creating User Policy", e);
        }
    }

    @Override
    public UserPolicy updateUserPolicy(UserPolicyDTO userpolicyDTO) {
        try {
            if (!userpolicyrepo.existsById(userpolicyDTO.getPolicyNo())) {
                throw new UserPolicyNotFoundException("User Policy not found with Policy No: " + userpolicyDTO.getPolicyNo());
            }

            User user = new User();
        	user = userRepo.findByUserId(userpolicyDTO.getUserId());
        	Policy policy = new Policy();
        	policy = policyRepo.findByPolicyId(userpolicyDTO.getPolicyId());
        	UserPolicy userpolicy = new UserPolicy();
        	PolicyPayment payment = new PolicyPayment();
        	payment.setAmount(policy.getAmount());
        	payment.setBank("HDFC Bank");
        	payment.setPaymentStatus("Completed");
        	payment.setPaymentDate(LocalDate.now());
        	
        	
            userpolicy.setStartDate(userpolicyDTO.getStartDate());
            int addYear = (int) policy.getTermNo();
            LocalDate endDate = userpolicyDTO.getStartDate().plusYears(addYear);
            userpolicy.setPolicyNo(userpolicyDTO.getPolicyNo());
            userpolicy.setEndDate(endDate);
            userpolicy.setPolicy(policy);
            userpolicy.setUser(user);
            payment.setUserPolicy(userpolicy);
            
            paymentRepo.save(payment);
            

            logger.info("User Policy updated successfully: {}", userpolicy);

            return userpolicy;
        } catch (UserPolicyNotFoundException e) {
            logger.error("Error updating User Policy", e);
            throw e;
        } catch (Exception e) {
            logger.error("Error updating User Policy", e);
            throw new RuntimeException("Error updating User Policy", e);
        }
    }
    
	@Transactional
    @Override
    public void deleteUserPolicyByPolicyNo(long policyNo) {
		System.out.print(policyNo);
		try {
        	System.out.print(policyNo);
            if (!userpolicyrepo.existsById(policyNo)) {
                throw new UserPolicyNotFoundException("User Policy not found with Policy No: " + policyNo);
            }else {

            userpolicyrepo.deleteById(policyNo);

            logger.info("User Policy deleted successfully with Policy No: {}", policyNo);}
        } catch (UserPolicyNotFoundException e) {
            logger.error("Error deleting User Policy", e);
            throw e;
        } catch (Exception e) {
            logger.error("Error deleting User Policy", e);
            throw new RuntimeException("Error deleting User Policy", e);
        }
    }

    @Override
    public UserPolicy getUserPolicyByPolicyNo(long policyNo) {
        try {
            UserPolicy userPolicy = userpolicyrepo.findById(policyNo).orElseThrow(
                    () -> new UserPolicyNotFoundException("User Policy not found with Policy No: " + policyNo));

            logger.info("User Policy retrieved successfully with Policy No: {}", policyNo);

            return userPolicy;
        } catch (UserPolicyNotFoundException e) {
            logger.error("Error getting User Policy by Policy No", e);
            throw e;
        } catch (Exception e) {
            logger.error("Error getting User Policy by Policy No", e);
            throw new RuntimeException("Error getting User Policy by Policy No", e);
        }
    }

    @Override
    public List<UserPolicy> getAllUserPolicy() {
        try {
            List<UserPolicy> userPolicies = userpolicyrepo.findAll();

            logger.info("Retrieved all User Policies successfully: {}", userPolicies);

            return userPolicies;
        } catch (Exception e) {
            logger.error("Error getting all User Policies", e);
            throw new RuntimeException("Error getting all User Policies", e);
        }
    }

	@Override
	public List<UserPolicy> getUserPolicyByUserId(User userId) {
		try {
            List<UserPolicy> userPolicy = userpolicyrepo.getUserPoliciesByUserId(userId);
            logger.info("User Policies retrieved successfully with User Id: {}", userId);

            return userPolicy;
        } catch (UserPolicyNotFoundException e) {
            logger.error("Error getting User Policy by User Id", e);
            throw e;
        } catch (Exception e) {
            logger.error("Error getting User Policy by User Id", e);
            throw new RuntimeException("Error getting User Policy by User Id", e);
        }
	}
}
