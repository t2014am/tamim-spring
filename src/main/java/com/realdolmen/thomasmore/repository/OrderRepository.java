package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Employee en Long)
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */
    //Order findByUserId(Long userId);
    //List<Order> findAll();

}
