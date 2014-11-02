package de.techdev.jaxenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Moritz Schulze
 */
@Service
public class FakeUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByFirstNameEquals(username);
        if (person == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return new User(username, "password", getGrantedAuthorities(username));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        Collection<? extends GrantedAuthority> authorities;
        if (username.equals("John")) {
            authorities = asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
        } else {
            authorities = asList(() -> "ROLE_BASIC");
        }
        return authorities;
    }
}
