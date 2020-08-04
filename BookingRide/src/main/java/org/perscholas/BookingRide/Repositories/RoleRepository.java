package org.perscholas.BookingRide.Repositories;

import java.util.Optional;

import org.perscholas.BookingRide.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	
	Optional<Role> findByName(String name);
	
	

}
