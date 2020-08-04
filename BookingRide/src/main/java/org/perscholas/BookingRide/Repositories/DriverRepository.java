package org.perscholas.BookingRide.Repositories;





import org.perscholas.BookingRide.models.Driver;
import org.perscholas.BookingRide.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{




}
