package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Employee en Long)
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */
    User findByFirstNameAndLastName(String firstName, String lastName);

    List<User> findAll();

//    User findById(Long id);
//
//    User deleteById(Long id);
}
