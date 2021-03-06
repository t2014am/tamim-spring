package com.realdolmen.thomasmore.service;

//import com.realdolmen.thomasmore.domain.User;

import com.realdolmen.thomasmore.domain.Authorities;
import com.realdolmen.thomasmore.domain.Users;
import com.realdolmen.thomasmore.repository.AuthoritiesRepository;
import com.realdolmen.thomasmore.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AuthoritiesRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void createUser(String firstName, String lastName, String email, String tel, String password, Date dob, boolean enabled, String username,String address,String city,String postalCode,String state) {
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(email);
//        user.setUsername(username);
        user.setTel(tel);
//        user.setPassword(password);
        user.setPassword(passwordEncoder.encode(password));
        user.setDob(dob);
        user.setEnabled(enabled);
        user.setAddress(address);
        user.setCity(city);
        user.setPostalCode(postalCode);
        user.setState(state);
//        user.setGender(gender);


        userRepository.save(user);

        Authorities auth = new Authorities(email, "ROLE_USER");
        authRepository.save(auth);
    }

    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    public Users findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }

    public void deleteUserById(Long id) {
//        return userRepository.deleteById(id);
        userRepository.delete(id);

    }

    public void updateUser(Long id, String firstName, String lastName, String email, String tel, String password, Date dob) {
        Users user = new Users();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
//        user.setUsername(email);
        user.setTel(tel);
//        user.setPassword(password);
        user.setPassword(passwordEncoder.encode(password));
        user.setDob(dob);
        userRepository.save(user);

    }
}
