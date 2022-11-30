package com.ecommerce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.exception.AddressException;
import com.ecommerce.exception.CartException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderExcetion;
import com.ecommerce.model.Address;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Session;
import com.ecommerce.repository.CartDao;
import com.ecommerce.repository.CustomerDao;
import com.ecommerce.repository.Orderdao;
import com.ecommerce.repository.SessionDao;

@Service
public class OrderServiceimpl  implements OrderService{

	
	 @Autowired
	  private SessionDao sdo;
	
	 @Autowired
	 private Orderdao od;
	
	 @Autowired
	 private CustomerDao cus;
	
	 
	 @Autowired
	 private CartDao cartdao;
	
	@Override
	public Orders addOrder(Orders order, String key) throws LoginException, CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		
		
		
		    Session ke = sdo.findByuuid(key);
		    
		    if(ke==null)
		    {
		    	throw new LoginException("You are not Authorized");
		    }
		    else
		    {
		    	
		    	
		    	 Integer customerId =  ke.getUserId();
		    	 
		    	 Optional<Customer>  s = cus.findById(customerId);
		    	 
		    	 Address ss = s.get().getAddress();
		    	 
		    	 Orders curr  = new Orders();
		    	 
		    	 curr.setOrderDate(LocalDate.now());
                 curr.setAddress( new AddressDto(ss.getStreetNo(), ss.getBulidingName(), ss.getCity(), ss.getState(), ss.getCountry(), ss.getPincode()));
                 curr.setCustomer(s.get());
                 curr.setOrderStatus("Order Confrimed");
                 
                 
                 List<ProductDto> list = cartdao.findByCustomer(s.get()).getProducts();
                 
                 if( list.size() < 1) {
    				 throw new CartException("Add product to the cart first...");
    			 }
                 
                 
                 
                 List<ProductDto> product = new ArrayList<ProductDto>();
                 
                 Double total = 0.0;
//                 for(ProductDto s: )
		    	
                 
                 for(ProductDto proDto : list) {
    				 
    				 product.add(proDto);
    				 
    				 total += (proDto.getPrice() * proDto.getQuantity()) ;
    				 
    			 }
                 
                 curr.setTotal(total);	
    			 curr.setPoder(product);
    			 
    			 
    			 
               Integer customerI =  ke.getUserId();
		    	 
		    	 Optional<Customer>  t = cus.findById(customerI);
    			 
    			 
    			 Cart customerCart = cartdao.findByCustomer(t.get()) ;
    			 
    			 customerCart.setProducts(new ArrayList<>());
    			 
    			 cartdao.save(customerCart);
    			 
    			 return od.save(curr);
                 
                 
		    }
		    
	
	}

	@Override
	public Orders updateCustomer(Orders order, String key) throws LoginException, CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		
	  Session s = sdo.findByuuid(key);
	  
	  if(s==null)
	  {
		  throw new LoginException("Sorry you are not Authorized");
	  }
	  else
	  {
		  Optional<Orders> opt=  od.findById(order.getOrderId());
		  
		  
		  if(opt.isPresent()) {
				return od.save(order);
			}
			else {
				throw new OrderExcetion("Order does not exist");
			}
		  
	  }
		
		
	}

	@Override
	public Orders removeOrder(Integer id, String key) throws LoginException, CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		Session s = sdo.findByuuid(key);
		
		if(s==null)
			{
			       throw new LoginException("You are not Authorized");
			}
		else
			{
			   Optional<Orders> ss = od.findById(id);
			   
			    if(ss.isEmpty())
			    {
			    	throw new  OrderExcetion("You Don't have orders prodcut");
			    }
			    else
			    {
			    	Orders se = ss.get();
			    	od.deleteById(id);
			    	
			    	return se;
			    }
			     
			}
	}

	@Override
	public Orders viewOrder(Integer id) throws CartException, OrderExcetion {
		// TODO Auto-generated method stub
		
		Optional<Orders> s = od.findById(id);
		
		Orders ss = s.get();
		
		
		return ss;
	}

	@Override
	public List<Orders> viewallOrderByDate(LocalDate date) throws OrderExcetion {
		// TODO Auto-generated method stub
		
		
		    List<Orders> s = od.findByorderDate(date);
		
		
		return s;
	}

	@Override
	public List<Orders> orderbylocation(String city) throws OrderExcetion, AddressException {
		// TODO Auto-generated method stub
		
		  
		
//		List<Orders> s = od.getOrderBycity(city);
		return null;
	}

	@Override
	public List<Orders> viewallbyuserid(String userid) throws OrderExcetion {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	
	
	
	
}
