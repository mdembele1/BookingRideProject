package org.perscholas.BookingRide.Services;

import java.util.List;


import org.perscholas.BookingRide.Repositories.TripRepository;
import org.perscholas.BookingRide.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
	@Autowired
	   private TripRepository repo;
	  
	   public List<Trip> listAll(){
	       return repo.findAll();
	       }
	  
	   public void save(Trip trip) {
	     repo.save(trip);
		   
		  
	   }
	  
	   public Trip get(int tripid) {
	       return repo.findAll().get(tripid);
	      
	   }
	  
	   public void delete(int tripid) {
	       repo.deleteById(tripid);
	   }


}
