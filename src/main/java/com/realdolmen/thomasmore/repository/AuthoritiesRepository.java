package com.realdolmen.thomasmore.repository;

//import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.domain.Authorities;
import com.realdolmen.thomasmore.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Employee en Long)
 */
@Repository
public interface AuthoritiesRepository extends CrudRepository<Users, Long> {
    void save(Authorities auth);

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */


//    List<Authorities> findAll();


//    Users findByFirstNameAndLastName(String firstName, String lastName);
//
//    Users findByEmail(String email);

//    Users save(Users user);

//    Users findById(Long id);
//
//    Users deleteById(Long id);
}
