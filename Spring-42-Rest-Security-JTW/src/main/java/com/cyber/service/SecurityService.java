package com.cyber.service;

import com.cyber.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    private UserService userService;

    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    // no need UserPrincipal - since it is only API
    //hey Spring - this is the user you need to authenticate !!
    //get the user form DB, and convert it to Spring User - so that Spring can do authentication !!
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User foundUser = loadUser(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException("User not found! " + username);
        }

        return new org.springframework.security.core.userdetails.User(foundUser.getUsername(),
                foundUser.getPassword(), listAuthorities(foundUser));
    }

    public User loadUser(String value){
        boolean isEmail = value.contains("@");
        return isEmail ? userService.readByEmail(value) : userService.readByUsername(value);
    }

    private List<GrantedAuthority> listAuthorities(User user) {

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getRole().name()));
        return grantedAuthorityList;
    }
}
