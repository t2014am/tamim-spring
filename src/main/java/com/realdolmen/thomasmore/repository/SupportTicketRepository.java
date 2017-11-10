package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Een interface die CrudRepository extend, we geven het type van de entity mee en de primary key. (Employee en Long)
 */
@Repository
public interface SupportTicketRepository extends CrudRepository<SupportTicket, Long> {

    /**
     * Beschrijf in de method name wat je wilt dat spring uit de database haalt, zo simpel is het!
     */
    List<SupportTicket> findAllByCustomer(User customer);
    SupportTicket findBySupport(User support);
    List<SupportTicket> findAll();
    //List<SupportTicket> findAllByUser(User user);
    SupportTicket findById(long id);

}
