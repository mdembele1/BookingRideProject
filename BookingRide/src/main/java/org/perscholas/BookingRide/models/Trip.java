package org.perscholas.BookingRide.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int tripid;
	
//	@NotNull
//	@Column(name = "Date")
	private Date tripdate;
	
//	@NotNull
//	@Size(max =50)
	//@Column(name = "Pickup Location")
	private String adressPickuplocat;
	
//	@NotNull
//	@Size(max =50)
//	@Column(name = "DropOff location")
	private String adressdropOfflocat;
	
//	@NotNull
//	@Size(max =5)
//	@Column(name = "Distance")
	private String distance;
	
//	@NotNull
//	@Size(max =6)
//	@Column(name = "CostPerMillage")
	private int costpermillage;
	
//	@NotNull
//	@Size(max =6)
//	@Column(name = "Fare")
	private int Proposfare;
	
//	@NotNull
//	@Size(max =10)
//	@Column(name = "Trip Status")
	private String tripStatus;
	
//	@NotNull
//	@Size(max =50)
//	@Column(name = "City Pickup")
	private String citypickupLoc;
	
//	@NotNull
//	@Size(max =50)
//	@Column(name = "City DropOff")
	private String cityropoffloc;
	
	@OneToMany (mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Driver> driver;

	
	@OneToMany (mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Passenger> passenger;

	
	public Trip() {
		super();
	}


	public Trip(int tripid, Date tripdate, String adressPickuplocat, String adressdropOfflocat, String distance,
			int costpermillage, int proposfare, String tripStatus, String citypickupLoc, String cityropoffloc,
			List<Driver> driver, List<Passenger> passenger) {
		super();
		this.tripid = tripid;
		this.tripdate = tripdate;
		this.adressPickuplocat = adressPickuplocat;
		this.adressdropOfflocat = adressdropOfflocat;
		this.distance = distance;
		this.costpermillage = costpermillage;
		this.Proposfare = proposfare;
		this.tripStatus = tripStatus;
		this.citypickupLoc = citypickupLoc;
		this.cityropoffloc = cityropoffloc;
		this.driver = driver;
		this.passenger = passenger;
	}


	public int getTripid() {
		return tripid;
	}


	public void setTripid(int tripid) {
		this.tripid = tripid;
	}


	public Date getTripdate() {
		return tripdate;
	}


	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}


	public String getAdressPickuplocat() {
		return adressPickuplocat;
	}


	public void setAdressPickuplocat(String adressPickuplocat) {
		this.adressPickuplocat = adressPickuplocat;
	}


	public String getAdressdropOfflocat() {
		return adressdropOfflocat;
	}


	public void setAdressdropOfflocat(String adressdropOfflocat) {
		this.adressdropOfflocat = adressdropOfflocat;
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) {
		this.distance = distance;
	}


	public int getCostpermillage() {
		return costpermillage;
	}


	public void setCostpermillage(int costpermillage) {
		this.costpermillage = costpermillage;
	}


	public int getProposfare() {
		return Proposfare;
	}


	public void setProposfare(int proposfare) {
		Proposfare = proposfare;
	}


	public String getTripStatus() {
		return tripStatus;
	}


	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}


	public String getCitypickupLoc() {
		return citypickupLoc;
	}


	public void setCitypickupLoc(String citypickupLoc) {
		this.citypickupLoc = citypickupLoc;
	}


	public String getCityropoffloc() {
		return cityropoffloc;
	}


	public void setCityropoffloc(String cityropoffloc) {
		this.cityropoffloc = cityropoffloc;
	}


	public List<Driver> getDriver() {
		return driver;
	}


	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}


	public List<Passenger> getPassenger() {
		return passenger;
	}


	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}


}
