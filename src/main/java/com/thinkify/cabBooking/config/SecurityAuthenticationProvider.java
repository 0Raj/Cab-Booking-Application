package com.thinkify.cabBooking.config;

import com.thinkify.cabBooking.exception.UserNotFoundException;
import com.thinkify.cabBooking.module.User;
import com.thinkify.cabBooking.repository.DriverDAO;
import com.thinkify.cabBooking.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Optional<User> optUser = userDAO.findById(authentication.getName());

        if (optUser.isPresent()){
            User user = optUser.get();

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(optUser.get().getRole());
            String authenticationPassword = authentication.getCredentials().toString();

            if (passwordEncoder.matches(authenticationPassword, user.getPassword())) {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                grantedAuthorities.add(simpleGrantedAuthority);

                return new UsernamePasswordAuthenticationToken(user.getMobileNumber(), authenticationPassword,
                        grantedAuthorities);
            } else {
                throw new BadCredentialsException("Bad Credentials");
            }

        }else {
            throw new UserNotFoundException("User not found");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
