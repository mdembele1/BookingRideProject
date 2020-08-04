package org.perscholas.BookingRide.Services;

import java.util.List;


import org.perscholas.BookingRide.Repositories.VehicleRepository;
import org.perscholas.BookingRide.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
	
	@Autowired
	   private VehicleRepository repo;
	  
	   public List<Vehicle> listAll(){
	       return repo.findAll();
	       }
	  
	   public void save(Vehicle vehicle) {
	     repo.save(vehicle);
		   
		  
	   }
	  
	   public Vehicle get(int vehid) {
	       return repo.getOne(vehid);
	    }
	  
	   public void delete(int vehid) {
	       repo.deleteById(vehid);

	   }
}
