package org.perscholas.BookingRide.Controllers;

import java.util.List;


import org.perscholas.BookingRide.Services.TripService;

import org.perscholas.BookingRide.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TripController {

@Autowired
	private TripService tripService;
	
		//********************************
		//Request Trips Form - Mapping 
		//********************************

	 @RequestMapping("/trip_request_form")
		public String viewTripRequestPage(Model model) {
		 Trip trip =new Trip();
		    model.addAttribute("trip", trip);
			
			return "trip_request_form";
		}
			
			//********************************
			//Saving Request Trips Form
			//********************************
		
		@RequestMapping(value="/trip_request_form", method=RequestMethod.POST)
		   public String SaveTripRequestPage(@ModelAttribute Trip trip, Model model) {
			tripService.save(trip);          
		       return "thank_you"; //Return to "Thank_You" Registration Form 
		 }
		
	// add mapping for "/list"
	@RequestMapping("/list_trip")
	public String listrip(Model model) {
				// get drivers from db
		List<Trip> trip = tripService.listAll();
//		Driver d = serviceDriver.getone(driverid);
//		Passenger p = servicePassenger.getOne(passid);
//		trip.setDriver(d);
//		
//		trip.setPassenger(p);
				// add to the spring model
		model.addAttribute("trips", trip);
				return "list_trip";
	}
	
	 @RequestMapping("/current_ride")
		public String viewCurrentridePage(Model model) {
		 Trip trip =new Trip();
		    model.addAttribute("trip", trip);
			
			return "current_ride";
		}
			
	
	  

}
