package org.perscholas.BookingRide.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.perscholas.BookingRide.Repositories.DriverRepository;
import org.perscholas.BookingRide.Repositories.RoleRepository;
import org.perscholas.BookingRide.Repositories.UserRepository;
import org.perscholas.BookingRide.models.Driver;
import org.perscholas.BookingRide.models.Role;
import org.perscholas.BookingRide.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private DriverRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public void save(User user) {
		
		//get roles and assign
		//get permissions and assign
        List<Role> roles = new ArrayList<>();
        Role role;
        Optional<Role> r = roleRepo.findByName("DRIVER");
        if (!r.isPresent()) {
            Role x = new Role();
            x.setName("ROLE_DRIVER");
            role = roleRepo.save(x);
        } else {
           role = r.get();
        }
		roles.add(role);
		
		user.setRole(roles);
		
		userRepo.save(user);
		Driver driver = new Driver();
		driver.SetUser(user);
		
		repo.save(driver);
		
				
	}
	
	public List<Driver> getAll() {
		return repo.findAll();
	}
	
	public Driver get(int driverid) {
		return repo.findById(driverid).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
	
//	public Driver findbytripId(Integer id) {
//		Driver d = repo.getByTripId(id);
//		
//		return d;
//	}
}
