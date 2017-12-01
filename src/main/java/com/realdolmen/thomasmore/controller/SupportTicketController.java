package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.SupportTicket;
import com.realdolmen.thomasmore.domain.Users;
import com.realdolmen.thomasmore.service.MessageService;
import com.realdolmen.thomasmore.service.SupportTicketService;
import com.realdolmen.thomasmore.service.UsersService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by JUZAU33 on 28/09/2017.
 */
@ManagedBean
@SessionScoped
public class SupportTicketController {

    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{supportTicketService}")
    private SupportTicketService supportTicketService;

    @ManagedProperty("#{userService}")
    private UsersService usersService;

    @ManagedProperty("#{messageService}")
    private MessageService messageService;

    private Users newCustomer;
    private Users newSupport;
    private String newSubject;
    private String messageToSend;

    private SupportTicket supportTicket;

    public List<SupportTicket> getSupportTickets() {
        return supportTicketService.findAllSupportTickets();
    }
    public SupportTicket getSupportTicketById(long id) {
        return supportTicketService.findSupportTicketById(id);
    }

    public List<SupportTicket> getSupportTicketsByCustomer() {
        return supportTicketService.findAllSupportTicketsByCustomer(usersService.findUserById((long)1));
    }

    /*public List<SupportTicket> getSupportTicketsBySupport() {
        return supportTicketService.findAllSupportTicketsBySupport();
    }*/


    /*public void createSupportTicket() {
        this.newCustomer = userService.findUserByEmail("dries@donckers.com");
        this.newSupport = userService.findUserByEmail("dries@donckers.com");
        supportTicketService.createSupportTicket(newCustomer, newSupport, newSubject);
        addMessage("Support ticket toegevoegd!");
        clearForm();
    }*/

    public void createSupportTicket() {
        this.newCustomer = usersService.findUserByEmail("dries@donckers.com");
        this.newSupport = usersService.findUserByEmail("dries@donckers.com");
        SupportTicket addedTicket = supportTicketService.createSupportTicket(newCustomer, newSupport, newSubject);
        addMessage("Support ticket toegevoegd!");
        messageService.createMessage(addedTicket, messageToSend, false);
        addMessage("Bericht verstuurd!");
        clearForm();
    }

    public SupportTicket getChosenTicket(Long id) {
        return this.supportTicket = supportTicketService.findSupportTicketById(id);
    }

    public String toSupportTicketPage(long id) {
        //setSupportTicket(supportTicketService.findSupportTicketById((long)1));
        //getChosenTicket(id);
        this.supportTicket = supportTicketService.findSupportTicketById(id);
        if(this.supportTicket != null){
            //do something
            System.out.println("Going to support ticket number: " + this.supportTicket.getId());
            System.out.println("supportticket details here: " + this.supportTicket.getSubject());
            return "supportticket?faces-redirect=true";
        } else {
            System.out.println("Nullpointer");
            //do something else
            return "supportticketlist";
        }
    }

    public String testValues(long id1, String subject1){
        System.out.println("id: " + this.supportTicket.getId() + " subject: " + this.supportTicket.getSubject());
        System.out.println("id: " + id1 + " subject: " + subject1);
        return "supportticketlist?faces-redirect=true";
    }


    /*public String toSupportTicketPage(SupportTicket supportTicket) {
        this.supportTicket = supportTicket;
        System.out.println("supportticket details here: " + this.supportTicket.toString());
        return "supportticket";
    }*/

    private void clearForm() {
        newCustomer = null;
        newSupport = null;
        newSubject = null;
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Users getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Users newCustomer) {
        this.newCustomer = newCustomer;
    }

    public Users getNewSupport() {
        return newSupport;
    }

    public void setNewSupport(Users newSupport) {
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

    public SupportTicket getSupportTicket() {
        return supportTicket;
    }

    public void setSupportTicket(SupportTicket supportTicket) {
        this.supportTicket = supportTicket;
    }



    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setSupportTicketService(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
