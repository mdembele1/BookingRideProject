package org.perscholas.BookingRide.Services;

import java.util.List;


import org.perscholas.BookingRide.Repositories.UserRepository;
import org.perscholas.BookingRide.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	  
	   public List<User> listAll(){
	       return repo.findAll();
	       }
	    
	   public void save(User user) {
		   
		   
	     repo.save(user);
		   
		  
	   }
	  
	   public User get(int user_id) {
	       return repo.findById(user_id).get();
	      
	   }
	  
	   public void delete(int user_id) {
	       repo.deleteById(user_id);

	   }

	public Page<User> findpage(Pageable pageable) {
	
		return repo.findAll(pageable);
	}

	public User findByEmail(String user_email) {
		User user = repo.LoginByEmail(user_email);
		return user;
	}
}

	
	
	
	

