package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.Message;
import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.service.MessageService;
import com.realdolmen.thomasmore.service.SupportTicketService;
import com.realdolmen.thomasmore.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by JUZAU33 on 28/09/2017.
 */
@ManagedBean
@SessionScoped
public class MessageController {

    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{supportTicketService}")
    private SupportTicketService supportTicketService;

    @ManagedProperty("#{messageService}")
    private MessageService messageService;

    private SupportTicket newSupportTicket;
    private String newSupportText;
    private boolean newBySupportUser;


    public List<Message> getMessages() {
        return messageService.findAllMessages();
    }
    public List<Message> getMessagesBySupportTicket(SupportTicket supportTicket) {
        return messageService.findAllMessagesBySupportTicket(supportTicket);
    }


    public void createMessage() {
        messageService.createMessage(newSupportTicket, newSupportText, newBySupportUser);
        addMessage("Bericht verzonden!");
        clearForm();
    }

    public void createMessage(SupportTicket supportTicket) {
        messageService.createMessage(supportTicket, newSupportText, false);
        addMessage("Bericht verzonden!");
        clearForm();
    }

    private void clearForm() {
        newSupportTicket = null;
        newSupportText = null;
        newBySupportUser = false;
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public SupportTicket getNewSupportTicket() {
        return newSupportTicket;
    }

    public void setNewSupportTicket(SupportTicket newSupportTicket) {
        this.newSupportTicket = newSupportTicket;
    }

    public String getNewSupportText() {
        return newSupportText;
    }

    public void setNewSupportText(String newSupportText) {
        this.newSupportText = newSupportText;
    }

    public boolean isNewBySupportUser() {
        return newBySupportUser;
    }

    public void setNewBySupportUser(boolean newBySupportUser) {
        this.newBySupportUser = newBySupportUser;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setSupportTicketService(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
