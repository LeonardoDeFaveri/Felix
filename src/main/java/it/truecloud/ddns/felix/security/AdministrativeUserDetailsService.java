package it.truecloud.ddns.felix.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.truecloud.ddns.felix.Errors;
import it.truecloud.ddns.felix.models.administrative_user.AdministrativeUser;
import it.truecloud.ddns.felix.models.administrative_user.AdministrativeUserRepository;

import java.util.ArrayList;

@Service
public class AdministrativeUserDetailsService implements UserDetailsService {
    @Autowired
    private AdministrativeUserRepository administrativeUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdministrativeUser retrievedUser = administrativeUserRepository.findByEmail(username);
        
        if (retrievedUser == null) throw new UsernameNotFoundException(Errors.USERNAME_NOT_FOUND);

        return new User(username, retrievedUser.getPassword(), new ArrayList<>());
    }
}