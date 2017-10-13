package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(String firstName, String lastName, String email, String tel, String password, Date dob) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTel(tel);
        user.setPassword(password);
        user.setDob(dob);
//        user.setGender(gender);

        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
