package org.perscholas.BookingRide.models;

import java.sql.Blob;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
//@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int vehid;
	
	
//	@Size(max =30)
//	@Column(name = "VIN")
	private String vin;
	
//	@NotNull
//	@Size(max =10)
//	@Column(name = "Plate Number")
	private String vehicplatenumber;
	
//	@NotNull
//	@Size(max =20)
//	@Column(name = "Picture")
	private Blob Vehicphoto;
	
//	@NotNull
//	@Size(max =50)
//	@Column(name = "Type")
	private String Vehictype;
	
//	@NotNull
//	@Size(max =25)
//	@Column(name = "Color")
	private String Vehicolor;
	
//	@NotNull
//	@Size(max =15)
//	@Column(name = "Model")
	private String Vehicmodel;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "driverid", nullable = false)
private Driver driver;

	
	public Vehicle() {
		super();
	}


	public Vehicle(int vehid, String vin, String vehicplatenumber, Blob vehicphoto, String vehictype, String vehicolor,
			String vehicmodel, Driver driver) {
		super();
		this.vehid = vehid;
		this.vin = vin;
		this.vehicplatenumber = vehicplatenumber;
		this.Vehicphoto = vehicphoto;
		this.Vehictype = vehictype;
		this.Vehicolor = vehicolor;
		this.Vehicmodel = vehicmodel;
		this.driver = driver;
	}


	public int getVehid() {
		return vehid;
	}


	public void setVehid(int vehid) {
		this.vehid = vehid;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public String getVehicplatenumber() {
		return vehicplatenumber;
	}


	public void setVehicplatenumber(String vehicplatenumber) {
		this.vehicplatenumber = vehicplatenumber;
	}


	public Blob getVehicphoto() {
		return Vehicphoto;
	}


	public void setVehicphoto(Blob vehicphoto) {
		Vehicphoto = vehicphoto;
	}


	public String getVehictype() {
		return Vehictype;
	}


	public void setVehictype(String vehictype) {
		Vehictype = vehictype;
	}


	public String getVehicolor() {
		return Vehicolor;
	}


	public void setVehicolor(String vehicolor) {
		Vehicolor = vehicolor;
	}


	public String getVehicmodel() {
		return Vehicmodel;
	}


	public void setVehicmodel(String vehicmodel) {
		Vehicmodel = vehicmodel;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
}
