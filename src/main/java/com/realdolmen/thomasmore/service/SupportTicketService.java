package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.Users;
import com.realdolmen.thomasmore.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    public SupportTicket createSupportTicket(Users customer, Users support, String subject) {
        SupportTicket supportTicket = new SupportTicket();
        supportTicket.setCustomer(customer);
        supportTicket.setSupport(support);
        supportTicket.setSubject(subject);

        supportTicketRepository.save(supportTicket);

        return findSupportTicketById(supportTicket.getId());
        //return null;
    }

    public List<SupportTicket> findAllSupportTickets() {
        return supportTicketRepository.findAll();
    }
    public List<SupportTicket> findAllSupportTicketsByCustomer(Users customer) {
        return supportTicketRepository.findAllByCustomer(customer);
    }
    public SupportTicket findSupportTicketById(long id) {return supportTicketRepository.findById(id);}

}
