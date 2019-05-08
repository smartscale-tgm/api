package io.swagger.security;

import io.swagger.database.MongoUser;
import io.swagger.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MongoUser mongoUser = userRepository.findByEmail(email);
        if (mongoUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(mongoUser.getId(), mongoUser.getPassword(), getAuthorities(mongoUser.getRoles()));
    }

    public static List<GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> ret = new ArrayList<>();
        for(String role : roles) {
            ret.add(new SimpleGrantedAuthority(role));
        }
        return ret;
    }

}
