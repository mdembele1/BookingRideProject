package org.perscholas.BookingRide.models;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity	
public class Driver {
	


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int driverid;
	
	
//	@Size(max =30)
//	@Column(name = "First Name")
	private String driverfname;
	
//	@NotNull
//	@Size(max =30)
//	@Column(name = "Last Name")
	private String driverlname;
	
		

//	@NotNull
//	@Size(max =20)
//	@Column(name = "Driver Licence")
	private Blob driverlicencephot;
	
//	@NotNull
//	@Size(max =15)
//	@Column(name = "DL Number")
	private String driverlicencenumb;
	
//	@NotNull
//	@Size(max =80)
//	@Column(name = "Address")
	private String driveradress;
	
//	@NotNull
//	@Size(max =2)
//	@Column(name = "Rating")
	private int rating;
	
//	@NotNull
//	@Size(max =30)
//	@Column(name = "Status")
	private int status;
	
@OneToMany (mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Vehicle> vehicle;

@ManyToOne(fetch = FetchType.LAZY, optional = true)
@JoinColumn(name = "tripid", nullable = true)
private Trip trip;

@OneToOne
private User user;

	public Driver() {
		super();
	}


	


	public Driver(int driverid, String driverfname, String driverlname, 
			 Blob driverlicencephot, String driverlicencenumb, String driveradress, int rating,
			int status, List<Vehicle> vehicle, Trip trip, List<Role> role, User user) {
		super();
		this.driverid = driverid;
		this.driverfname = driverfname;
		this.driverlname = driverlname;
		this.driverlicencephot = driverlicencephot;
		this.driverlicencenumb = driverlicencenumb;
		this.driveradress = driveradress;
		this.rating = rating;
		this.status = status;
		this.vehicle = vehicle;
		this.trip = trip;
		this.user = user;
	}





	public int getDriverid() {
		return driverid;
	}


	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}


	public String getDriverfname() {
		return driverfname;
	}


	public void setDriverfname(String driverfname) {
		this.driverfname = driverfname;
	}


	public String getDriverlname() {
		return driverlname;
	}


	public void setDriverlname(String driverlname) {
		this.driverlname = driverlname;
	}





	public Blob getDriverlicencephot() {
		return driverlicencephot;
	}


	public void setDriverlicencephot(Blob driverlicencephot) {
		this.driverlicencephot = driverlicencephot;
	}


	public String getDriverlicencenumb() {
		return driverlicencenumb;
	}


	public void setDriverlicencenumb(String driverlicencenumb) {
		this.driverlicencenumb = driverlicencenumb;
	}


	public String getDriveradress() {
		return driveradress;
	}


	public void setDriveradress(String driveradress) {
		this.driveradress = driveradress;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public List<Vehicle> getVehicle() {
		return vehicle;
	}


	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}


	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public User getUser() {
		return user;
	}
	public void SetUser(User user) {
		this.user =user;
	}



}
