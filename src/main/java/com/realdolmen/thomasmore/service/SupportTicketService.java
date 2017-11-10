package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.primefaces.component.keyboard.Keyboard.PropertyKeys.password;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    public SupportTicket createSupportTicket(User customer, User support, String subject) {
        SupportTicket supportTicket = new SupportTicket();
        supportTicket.setCustomer(customer);
        supportTicket.setSupport(support);
        supportTicket.setSubject(subject);

        supportTicketRepository.save(supportTicket);

        return findSupportTicketById(supportTicket.getId());
    }

    public List<SupportTicket> findAllSupportTickets() {
        return supportTicketRepository.findAll();
    }
    public List<SupportTicket> findAllSupportTicketsByCustomer(User customer) {
        return supportTicketRepository.findAllByCustomer(customer);
    }
    public SupportTicket findSupportTicketById(long id) {return supportTicketRepository.findById(id);}

}
