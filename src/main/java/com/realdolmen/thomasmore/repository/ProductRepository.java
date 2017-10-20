package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Product en Long)
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */
    Product findByName(String name);
    List<Product> findAll();


}
