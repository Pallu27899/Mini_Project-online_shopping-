package com.ecommerce.service;

import com.ecommerce.exception.LoginException;
import com.ecommerce.model.Login;

public interface LoginService {
	
	
	public String logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	

}
