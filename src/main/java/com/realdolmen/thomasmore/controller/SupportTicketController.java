package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.service.SupportTicketService;
import com.realdolmen.thomasmore.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

/**
 * Created by JUZAU33 on 28/09/2017.
 */
@ManagedBean
@ViewScoped
public class SupportTicketController {

    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{userService}")
    private SupportTicketService supportTicketService;

    private User newCustomer;
    private User newSupport;
    private String newSubject;


    public List<SupportTicket> getSupportTickets() {
        return supportTicketService.findAllSupportTickets();
    }


    public void createSupportTicket() {
        supportTicketService.createSupportTicket(newCustomer, newSupport, newSubject);
        addMessage("Support ticket toegevoegd!");
        clearForm();
    }

    private void clearForm() {
        newCustomer = null;
        newSupport = null;
        newSubject = null;
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setSupportTicketService(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }
}
