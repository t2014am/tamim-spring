package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.User;
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
public class UserController {

    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{userService}")
    private UserService userService;

    private String newUserFirstName;
    private String newUserLastName;
    private String newUserEmail;
    private String newUserTel;
    private String newUserPassword;
    private Date newUserDob;
    private Date newUserGender;


    public List<User> getUsers() {
        return userService.findAllUsers();
    }


    public void createUser() {
        userService.createUser(newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob);
        addMessage("User toegevoegd!");
        clearForm();
    }

    private void clearForm() {
        newUserFirstName = null;
        newUserLastName = null;
        newUserEmail = null;
        newUserTel = null;
        newUserPassword = null;
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getNewUserFirstName() {
        return newUserFirstName;
    }

    public String getNewUserLastName() {
        return newUserLastName;
    }

    public void setNewUserFirstName(String newUserFirstName) {
        this.newUserFirstName = newUserFirstName;
    }

    public void setNewUserLastName(String newUserLastName) {
        this.newUserLastName = newUserLastName;
    }

    public String getNewUserEmail() {
        return newUserEmail;
    }

    public void setNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
    }

    public String getNewUserTel() {
        return newUserTel;
    }

    public void setNewUserTel(String newUserTel) {
        this.newUserTel = newUserTel;
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }

    public Date getNewUserDob() {
        return newUserDob;
    }

    public void setNewUserDob(Date newUserDob) {
        this.newUserDob = newUserDob;
    }

    public Date getNewUserGender() {
        return newUserGender;
    }

    public void setNewUserGender(Date newUserGender) {
        this.newUserGender = newUserGender;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
