package org.perscholas.BookingRide.Repositories;

import org.perscholas.BookingRide.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User LoginByEmail(String user_email);


}
