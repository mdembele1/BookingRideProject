package org.perscholas.BookingRide.Services;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private Map<String, User> roles = new HashMap<>();
    @PostConstruct
    public void init() {
        roles.put("driver", new User("driver", "{noop}driver1", getAuthority("ROLE_DRIVER")));
        roles.put("passenger", new User("passenger", "{noop}passenger1", getAuthority("ROLE_PASSENGER")));
    }
    @Override
    public UserDetails loadUserByUsername(String user_email) {
        return roles.get(user_email);
    }
    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
    

}
