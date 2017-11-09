package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String firstName, String lastName, String email, String tel, String password, Date dob) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTel(tel);
        user.setPassword(passwordEncoder.encode(password));
        user.setDob(dob);
//        user.setGender(gender);

        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUserById(Long id) {
//        return userRepository.deleteById(id);
        userRepository.delete(id);

    }

    public void updateUser(Long id, String firstName, String lastName, String email, String tel, String password, Date dob) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTel(tel);
        user.setPassword(passwordEncoder.encode(password));
        user.setDob(dob);
        userRepository.save(user);

    }

    public User authenticateUser(String username,String password){
        return userRepository.findByEmail(username);
//        if (username == "username" && password == "password"){
//            return System.out.println("hakuna matata");
//        }
//        return System.out.println("null");
    }

}
