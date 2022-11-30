package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.LoginException;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Login;
import com.ecommerce.model.Session;
import com.ecommerce.repository.AdminDao;
import com.ecommerce.repository.CustomerDao;
import com.ecommerce.repository.SessionDao;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl  implements LoginService{

	
	 
	@Autowired
	private CustomerDao cus;
	
	@Autowired
	private SessionDao ses;
	
	
	@Autowired
	private AdminDao ad;
	
	@Override
	public String logIntoAccount(Login dto) throws LoginException {
		// TODO Auto-generated method stub
		
		  if(dto.getRoll().equalsIgnoreCase("admin"))
		  {
			  Admin ads  = ad.findByemail(dto.getEmail());
			  
			  if(ads == null)
			  {
				  throw new LoginException("OOps Login failed Pleas try again");
			  }
			  
			  Optional<Session> validCustomerSessionOpt =  ses.findById(ads.getAdminId());
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			     if(ads.getPassword().equals(dto.getPassword()))
			     {
			    	 String key= RandomString.make(6);
			    	 
			    	 Session ss = new Session(ads.getAdminId(), key, LocalDateTime.now());
			    	 
			    	 ses.save(ss);
			    	 return ss.toString();
			     }
			     else
			     {
			    	 throw new LoginException("Please Enter a valid password");
			     }
			  
			      
			  
		  }
		  else
		  {
			  Customer existingCustomer=  cus.findByemail(dto.getEmail());
			  
			  
			  if(existingCustomer == null) {
					
					throw new LoginException("Please Enter a valid email  and password");
					
					 
				}
			  
			  
			  Optional<Session> validCustomerSessionOpt =  ses.findById(existingCustomer.getCustomerId());
			  
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			  if(existingCustomer.getPassword().equals(dto.getPassword())) {
					
					String key= RandomString.make(6);
					
					
					
					Session currentUserSession = new Session(existingCustomer.getCustomerId(),key,LocalDateTime.now());
					
					ses.save(currentUserSession);

					return currentUserSession.toString();
				}
			  else
			  {
				  throw new LoginException("Pleas enter the valid email or password");
			  }
			  
		  }
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		Session validCustomerSession = ses.findByuuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
ses.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}
	
	
	

}
