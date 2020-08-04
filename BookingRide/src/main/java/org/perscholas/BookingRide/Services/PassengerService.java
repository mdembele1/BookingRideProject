package org.perscholas.BookingRide.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.perscholas.BookingRide.Repositories.PassengerRepository;
import org.perscholas.BookingRide.Repositories.RoleRepository;
import org.perscholas.BookingRide.Repositories.UserRepository;
import org.perscholas.BookingRide.models.Passenger;
import org.perscholas.BookingRide.models.Role;
import org.perscholas.BookingRide.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
	
	@Autowired
    private  BCryptPasswordEncoder encode;
	
	@Autowired
	   private PassengerRepository repo;
	
	@Autowired
	   private RoleRepository Rolerepo;
	
	@Autowired
	   private UserRepository Userrepo;  
	
	   public List<Passenger> listAll(){
	       return repo.findAll();
	       }
	    
	   public void save(User user) {
			
			//get roles and assign
			//get permissions and assign
	        List<Role> roles = new ArrayList<>();
	        Role role;
	        Optional<Role> r = Rolerepo.findByName("PASSENGER");
	        if (!r.isPresent()) {
	            Role x = new Role();
	            x.setName("ROLE_PASSENGER");
	            role = Rolerepo.save(x);
	        } else {
	           role = r.get();
	        }
			roles.add(role);
			
			user.setRole(roles);
			
			Userrepo.save(user);
			Passenger passenger = new Passenger();
			passenger.setUser(user);
						
			repo.save(passenger);
			
					
		}
	  
	   public Passenger get(int passid) {
	       return repo.findById(passid).get();
	      
	   }
	  
	   public void delete(int passid) {
	       repo.deleteById(passid);

	   }

	public Page<Passenger> findpage(Pageable pageable) {
	
		return repo.findAll(pageable);
	}
	

	
}
