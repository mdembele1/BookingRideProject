package org.perscholas.BookingRide.models;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;





@Entity
public class Passenger {
	
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int passid;
	
	
//	@Size(max =30)
	@Column(name = "First_Name")
	private String passfname;
	
//	@NotNull
//	@Size(max =30)
	@Column(name = "Last_Name")
	private String Passlname;
	
	private String email;
	
	private String passpwd;
	
	private String passphone;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "tripid", nullable = true)
	private  Trip trip;
	
	@OneToOne
	private User user;

	public Passenger() {
		super();
	}

	public Passenger(int passid, String passfname, String passlname, String email,
			String passpwd,String passphone, Trip trip, User user) {
		super();
		this.passid = passid;
		this.passfname = passfname;
		this.Passlname = passlname;
		this.email=email;
		this.passpwd=passpwd;
		this.passphone=passphone;
		this.trip = trip;
		this.user = user;
	}


	public int getPassid() {
		return passid;
	}

	public void setPassid(int passid) {
		this.passid = passid;
	}

	public String getPassfname() {
		return passfname;
	}

	public void setPassfname(String passfname) {
		this.passfname = passfname;
	}

	public String getPasslname() {
		return Passlname;
	}

	public void setPasslname(String passlname) {
		Passlname = passlname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasspwd() {
		return passpwd;
	}

	public void setPasspwd(String passpwd) {
		this.passpwd = passpwd;
	}

	public String getPassphone() {
		return passphone;
	}

	public void setPassphone(String passphone) {
		this.passphone = passphone;
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

	public void setUser(User user) {
		this.user = user;
	}

	


	
	
}
