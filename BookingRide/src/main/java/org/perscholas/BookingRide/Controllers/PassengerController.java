package org.perscholas.BookingRide.Controllers;




import java.util.List;

import org.perscholas.BookingRide.Services.PassengerService;
import org.perscholas.BookingRide.models.Passenger;
import org.perscholas.BookingRide.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;







@Controller
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	
	

	

	//********************************
	//Mapping User Registration Form
	//********************************

	 @RequestMapping("/passenger_registration")
	  public String showNewPassengerForm(Model model) {
		 User user =new User();
	    model.addAttribute("user", user);
	    
	    return "passenger_registration";
	 }
			
		//********************************
		//Saving PASSENGER Registration Form
		//********************************
	 @RequestMapping(value="/passenger_registration", method=RequestMethod.POST)
	   public String SavepassengerRegistForm(@ModelAttribute User user, Model model) {
		
		passengerService.save(user);          
	       return "redirect:/login"; //Return to Vehicle Registration Form 
	 }

	
	
	
	
	
	
    
//	 @RequestMapping("/passenger_registration")
//	  public String PassengerForm(Model model) {
//		 Passenger passenger =new Passenger();
//	    model.addAttribute("passenger", passenger);
//	    return "passenger_registration";
//	  }	
//
//	   @RequestMapping(value="/passenger_registration", method = RequestMethod.POST)
//	   public String savePassenger(@ModelAttribute Passenger passenger, Model model) {
//		  
//		   	   passengerService.save(passenger);
//		   	 
//	            return "redirect:/login ";
//		   }
	  
	   @GetMapping("/list_passenger")
		public String showPassengerListPage(Model model) {
			List<Passenger> passengerlist = passengerService.listAll();
			model.addAttribute("passengerlist", passengerlist);
				return "list_passenger";
		}
	   

		@PostMapping("/UpdatePassenger")
		public String showFormForUpdate(@RequestParam("passid") int passid,
										Model model) {
			
			// get the passenger from the service
			Passenger passenger = passengerService.get(passid);
			
			// set passenger as a model attribute to pre-populate the form
			model.addAttribute("passenger", passenger);
			
			// send over to our form
			return "passenger_registration";			
		}
		
		

		@PostMapping("/list_passenger")
		public String delete(@RequestParam("passid") int passid) {
			
			// delete the passenger
			passengerService.delete(passid); 
			
			// redirect to /list_passenger
			return "redirect:/list_passenger";
			
		}
		
	  

}
