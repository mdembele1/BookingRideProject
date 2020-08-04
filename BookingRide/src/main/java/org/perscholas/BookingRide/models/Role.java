package org.perscholas.BookingRide.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.security.core.GrantedAuthority;


@Entity
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 2391450153596242961L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id_role;
	
	private String name;
	
	
	
	public Role() {
		super();
	}

	public Role(int id_role, String name ) {
		super();
		this.id_role = id_role;
		this.name = name;
	
	}
	

	 @Override
	    public boolean equals(Object o) {
	        if (o == this)
	            return true;
	        if (!(o instanceof Role)) {
	            return false;
	        }
	        Role role = (Role) o;
	        return Objects.equals(id_role, role.id_role) && Objects.equals(name, role.name);
	    }


	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public int hashCode() {
        return Objects.hash(id_role, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId_role() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}







	




}
