package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.service.MessageService;
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
    @ManagedProperty("#{supportTicketService}")
    private SupportTicketService supportTicketService;

    @ManagedProperty("#{userService}")
    private UserService userService;

    @ManagedProperty("#{messageService}")
    private MessageService messageService;

    private User newCustomer;
    private User newSupport;
    private String newSubject;
    private String messageToSend;


    public List<SupportTicket> getSupportTickets() {
        return supportTicketService.findAllSupportTickets();
    }


    /*public void createSupportTicket() {
        this.newCustomer = userService.findUserByEmail("dries@donckers.com");
        this.newSupport = userService.findUserByEmail("dries@donckers.com");
        supportTicketService.createSupportTicket(newCustomer, newSupport, newSubject);
        addMessage("Support ticket toegevoegd!");
        clearForm();
    }*/

    public void createSupportTicket() {
        this.newCustomer = userService.findUserByEmail("dries@donckers.com");
        this.newSupport = userService.findUserByEmail("dries@donckers.com");
        SupportTicket addedTicket = supportTicketService.createSupportTicket(newCustomer, newSupport, newSubject);
        addMessage("Support ticket toegevoegd!");
        messageService.createMessage(addedTicket, messageToSend, false);
        addMessage("Bericht verstuurd!");
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

    public User getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(User newCustomer) {
        this.newCustomer = newCustomer;
    }

    public User getNewSupport() {
        return newSupport;
    }

    public void setNewSupport(User newSupport) {
        this.newSupport = newSupport;
    }

    public String getNewSubject() {
        return newSubject;
    }

    public void setNewSubject(String newSubject) {
        this.newSubject = newSubject;
    }

    public String getMessageToSend() {
        return messageToSend;
    }

    public void setMessageToSend(String messageToSend) {
        this.messageToSend = messageToSend;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setSupportTicketService(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
