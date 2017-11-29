package com.realdolmen.thomasmore.repository;

//import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Employee en Long)
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */


    List<Users> findAll();


    //    Users findByFirstNameAndLastName(String firstName, String lastName);
//
    Users findByEmail(String email);

//    Users save(Users user);

//    Users findById(Long id);
//
//    Users deleteById(Long id);
}