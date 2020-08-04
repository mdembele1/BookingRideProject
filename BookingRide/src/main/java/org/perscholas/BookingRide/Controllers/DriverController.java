package org.perscholas.BookingRide.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.perscholas.BookingRide.Services.DriverService;
import org.perscholas.BookingRide.Services.UserService;
import org.perscholas.BookingRide.models.Driver;
import org.perscholas.BookingRide.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private UserService userService;
	
	
	//********************************
	//Mapping User Registration Form
	//********************************

	 @RequestMapping("/driver_registration")
	  public String showNewDriverForm(Model model) {
		 User user =new User();
	    model.addAttribute("user", user);
	    
	    return "driver_registration";
	 }
			
		//********************************
		//Saving Driver Registration Form
		//********************************
	
	@RequestMapping(value="/driver_registration", method=RequestMethod.POST)
	   public String SavedriverRegistForm(@ModelAttribute User user, Model model) {
		
		driverService.save(user);          
	       return "redirect:/login"; //Return to Vehicle Registration Form 
	 }

			//********************************
			//Add mapping for "/listdrivers"
			//********************************
	
	@RequestMapping("/list_driver")
	public String listDrivers(Model model) {
				// get drivers from db
		List<Driver> driver = driverService.getAll();
				// add to the spring model
		model.addAttribute("driver", driver);
				return "list_driver";
	}
	
	  		//*******************************
			//Add mapping for "/gallery"	*
			//*******************************
		  
	  @RequestMapping("/gallery")
		public String viewGallery() {
			
		  return "gallery";
	  }
	  
	  	//***********************************************
		//Add mapping for "/thank_you"	End ride request*
		//***********************************************

	  
	  
//	  @RequestMapping("/login")
//		public String Viewlogin() {
//		
//			return "login";
//		}
//	 
	  
	  
	  
	  
	  @RequestMapping("/thank_you")
		public String ThankYou() {
		
			return "thank_you";
		}
	 
	  		//***********************************************
			//Show Driver Form For Update
			//***********************************************
		@PostMapping("/UpdateDriver")
		public String showFormForUpdate(@RequestParam("driverid") int driverid,
										Model model) {
			
			// get the driver from driverService
			Driver driver = driverService.get(driverid);
					
			// set driver as a model attribute to pre-populate the form
			model.addAttribute("driver", driver);
			
			// send over to our form
			return "driver_registration";			
		}
		
		//***********************************************
		//Delete by ID a diver  object
		//***********************************************

		@PostMapping("/list_driver")
		public String delete(@RequestParam("driverid") int driverid) {
			
			// delete the driver
			driverService.delete(driverid); 
			
			// redirect to /list_driver
			return "redirect:/list_driver";
			
		}
//		@RequestMapping("/login")
//		public String loginUser(@RequestParam String user_email, @RequestParam String user_pwd, HttpSession session) {
//				User user = userService.findByEmail(user_email);
//				
//			session.setAttribute("currentUser", user);
//			return "passenger_registration";
//		}
	
		@RequestMapping("/login")
		public String loginUser(Model model) {
			 User user =new User();
		model.addAttribute("user", user);
			    
				return "login";
		}	
		
		
		@PostMapping("/login")
		public String loginUser(@RequestParam String user_email, @RequestParam String user_pwd, HttpSession session) {
			User user =userService.findByEmail(user_email);
			session.setAttribute("currentUser", user);
			return "redirect:/trip_request_form";
		}
	  

}
	


