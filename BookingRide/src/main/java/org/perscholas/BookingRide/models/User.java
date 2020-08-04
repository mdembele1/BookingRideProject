package org.perscholas.BookingRide.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NamedQuery(name = "User.LoginByEmail", query = "select u from User u where u.user_email = ?1")
public class User implements UserDetails {
	
	private static final long serialVersionUID = -3066607980419798945L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int user_id;
	
	@Email(message="Please enter a valid email.")
	@NotBlank(message="Email is required.")
    @Column(unique = true)
	private String user_email;
	
	
	private String userfirstname;
		
	private String userlastname;
	
	private String user_pwd;
		
	private String user_phone;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Role> role = new ArrayList<>();
	
	  @OneToOne(cascade=CascadeType.PERSIST)
	 private Passenger passenger;
	
	  @OneToOne(cascade=CascadeType.PERSIST)
	private Driver driver;

	public User() {
		super();
	}


	public User(int user_id, @NotNull @Email String user_email, String user_pwd, String user_phone,
			String userfirstname,String userlastname,List<Role> role, Passenger passenger, Driver driver) {
		super();
		this.user_id = user_id;
		this.user_email = user_email;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.role = role;
		this.passenger = passenger;
		this.driver = driver;
		this.userfirstname=userfirstname;
		this.userlastname =userlastname;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pwd() {
		return user_pwd;
	}


	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}


	public String getUserfirstname() {
		return userfirstname;
	}


	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}


	public String getUserlastname() {
		return userlastname;
	}


	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public List<Role> getRole() {
		return role;
	}


	public void setRole(List<Role> role) {
		this.role = role;
	}




	public Passenger getPassenger() {
		return passenger;
	}




	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}




	public Driver getDriver() {
		return driver;
	}




	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user_pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user_email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	public void setPassword(String encryptPwd) {
		this.setPassword(encryptPwd);
		
	}


}
