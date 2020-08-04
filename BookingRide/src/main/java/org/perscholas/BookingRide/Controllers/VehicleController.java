//package org.perscholas.BookingRide.Controllers;
//
//import java.util.List;
//
//import org.perscholas.BookingRide.Services.DriverService;
//import org.perscholas.BookingRide.Services.VehicleService;
//import org.perscholas.BookingRide.models.Driver;
//import org.perscholas.BookingRide.models.Vehicle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class VehicleController {
//
//	@Autowired
//	private VehicleService vehicleService;
//
//	private VehicleController(VehicleService theVehicleService) {
//		vehicleService = theVehicleService;
//	}
//
//	// add mapping for "/list"
//
//	@RequestMapping("/listvehicle")
//	public String listVehicle(Model model) {
//		// get drivers from db
//		List<Vehicle> theVehicles = vehicleService.listAll();
//		// add to the spring model
//		model.addAttribute("theVehicles", theVehicles);
//		return "list-driver";
//	}
//
//	@RequestMapping("/vehicle_registration")
//	public String showNewVehicleForm(Model model, @RequestParam Integer driverid) {
//		Vehicle vehicle = new Vehicle();
////		Driver d = driverService.getOne(driverid);
//		
//		
//		model.addAttribute("vehicle", vehicle);
//		return "vehicle_registration";
//	}
//
//	@RequestMapping(value = "/vehicle_registration", method = RequestMethod.POST)
//	public String saveVehicles(@ModelAttribute("vehicle") Vehicle vehicle) {
//		vehicleService.save(vehicle);
//		return "redirect:/login";
//
//	}
//
//	@RequestMapping("/login")
//	public String viewLoginPage() {
//
//		return "login";
//	}
//
//}
