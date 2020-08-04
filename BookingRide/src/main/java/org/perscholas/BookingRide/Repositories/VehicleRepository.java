package org.perscholas.BookingRide.Repositories;



import org.perscholas.BookingRide.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle,Integer>{
	
}
