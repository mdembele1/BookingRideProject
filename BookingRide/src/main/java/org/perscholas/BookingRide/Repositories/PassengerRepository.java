package org.perscholas.BookingRide.Repositories;

import org.perscholas.BookingRide.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
