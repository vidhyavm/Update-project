package com.hexaware.policymanagement.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.policymanagement.dto.PolicyPaymentDTO;
import com.hexaware.policymanagement.entity.PolicyPayment;
import com.hexaware.policymanagement.exception.TransactionNotFoundException;
import com.hexaware.policymanagement.repository.PolicyPaymentRepository;
/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: PolicyPayment Service Implementaion
 */
/* Author:Devanshu
 * @UpdatedOn:-16-11-2023
 * Description: Added Exception and Logger
 */
@Service
public class PolicyPaymentServicesImp implements IPolicyPaymentServices {

    private static final Logger logger = LoggerFactory.getLogger(PolicyPaymentServicesImp.class);

    @Autowired
    PolicyPaymentRepository policypayrepo;
    
    String notFound = "Transaction not found with TxnId: ";
    String txNotFound = "Transaction not found";


    @Override
    public PolicyPayment createPolicyPayment(PolicyPaymentDTO policyPaymentDTO) 
    {
        try 
        {
            PolicyPayment policyPayment = new PolicyPayment();
            policyPayment.setAmount(policyPaymentDTO.getAmount());
            policyPayment.setBank(policyPaymentDTO.getBank());
            policyPayment.setFine(policyPaymentDTO.getFine());
            policyPayment.setPaymentDate(policyPaymentDTO.getPaymentDate());
            policyPayment.setPaymentStatus(policyPaymentDTO.getPaymentStatus());
            policyPayment.setUserPolicy(policyPaymentDTO.getUserPolicy());

            PolicyPayment createdPolicyPayment = policypayrepo.save(policyPayment);

            logger.info("Policy Payment created successfully: {}", createdPolicyPayment);

            return createdPolicyPayment;
        } 
        catch (Exception e) 
        {
            logger.error("Error creating Policy Payment", e);
            throw new RuntimeException("Error creating Policy Payment", e);
        }
    }

    @Override
    public PolicyPayment updatePolicyPayment(PolicyPaymentDTO policyPaymentDTO) {
        try 
        {
            if (!policypayrepo.existsById(policyPaymentDTO.getTxnId())) 
            {
                throw new TransactionNotFoundException(notFound + policyPaymentDTO.getTxnId());
            }

            PolicyPayment policyPayment = new PolicyPayment();
            policyPayment.setTxnId(policyPaymentDTO.getTxnId());
            policyPayment.setAmount(policyPaymentDTO.getAmount());
            policyPayment.setBank(policyPaymentDTO.getBank());
            policyPayment.setFine(policyPaymentDTO.getFine());
            policyPayment.setPaymentDate(policyPaymentDTO.getPaymentDate());
            policyPayment.setPaymentStatus(policyPaymentDTO.getPaymentStatus());
            policyPayment.setUserPolicy(policyPaymentDTO.getUserPolicy());

            PolicyPayment updatedPolicyPayment = policypayrepo.save(policyPayment);

            logger.info("Policy Payment updated successfully: {}", updatedPolicyPayment);

            return updatedPolicyPayment;
        } 
        catch (Exception e) 
        {
            logger.error("Error updating Policy Payment", e);
            throw new RuntimeException("Error updating Policy Payment", e);
        }
    }

    @Override
    public void deletePolicyPaymentByTxnId(long txnId) 
    {
        try 
        {
            if (!policypayrepo.existsById(txnId)) 
            {
                throw new TransactionNotFoundException(notFound + txnId);
            }

            policypayrepo.deleteById(txnId);

            logger.info("Policy Payment deleted successfully with TxnId: {}", txnId);
        } 
        	catch (TransactionNotFoundException e) 
        {
            logger.error(txNotFound, e);
            throw e;  
        } 
        	catch (Exception e) 
        {
            logger.error("Error deleting Policy Payment", e);
            throw new RuntimeException("Error deleting Policy Payment", e);
        }
    }

    @Override
    public PolicyPayment getPolicyPaymentByTxnId(long txnId) 
    {
        try 
        {
            PolicyPayment policyPayment = policypayrepo.findById(txnId)
                    .orElseThrow(() -> new TransactionNotFoundException(notFound + txnId));

            logger.info("Retrieved Policy Payment by TxnId successfully: {}", policyPayment);

            return policyPayment;
        } 
        catch (TransactionNotFoundException e) 
        {
            logger.error(txNotFound, e);
            throw e;  
        } 
        catch (Exception e) 
        {
            logger.error("Error getting Policy Payment by TxnId", e);
            throw new RuntimeException("Error getting Policy Payment by TxnId", e);
        }
    }

    @Override
    public PolicyPayment getPolicyPaymentByPolicyNo(PolicyPayment policyNo) 
    {
        try 
        {
            PolicyPayment policyPayment = policypayrepo.findByUserPolicy(policyNo);

            logger.info("Retrieved Policy Payment by PolicyNo successfully: {}", policyPayment);

            return policyPayment;
        } 
        catch (TransactionNotFoundException e) 
        {
            logger.error(txNotFound, e);
            throw e;  
        } 
        catch (Exception e) 
        {
            logger.error("Error getting Policy Payment by PolicyNo", e);
            throw new RuntimeException("Error getting Policy Payment by PolicyNo", e);
        }
    }

    @Override
    public List<PolicyPayment> getAllPolicyPayment() 
    {
        try 
        {
            List<PolicyPayment> policyPayments = policypayrepo.findAll();

            logger.info("Retrieved all Policy Payments successfully: {}", policyPayments);

            return policyPayments;
        } 
        catch (Exception e) 
        {
            logger.error("Error getting all Policy Payments", e);
            throw new RuntimeException("Error getting all Policy Payments", e);
        }
    }
}
