package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Product en Long)
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */
    Category findCategoryById(Long id);

    @Override
    List<Category> findAll();


}
