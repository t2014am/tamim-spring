package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.Authorities;
import com.realdolmen.thomasmore.domain.Users;
import com.realdolmen.thomasmore.service.UsersService;
import sun.rmi.runtime.Log;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Console;
import java.util.Date;
import java.util.List;

/**
 * Created by JUZAU33 on 28/09/2017.
 */
@ManagedBean
@SessionScoped
public class UsersController {

    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{usersService}")
    private UsersService userService;

    private Long userId = new Long(0);
    private String newUserFirstName = "tamim";
    private String newUserLastName = "asefi";
    private String newUserEmail = "asdf@fff.com";
    private String newUserTel = "tel";
    private String newUserPassword = "asdff";
    private Date newUserDob;
    private Date newUserGender;

    //REQUIRED BY SPRING SECURITY
    private boolean enabled = true;
    private String username;

    private Authorities auth;

    private Users user;


    public List<Users> getUsers() {
        return userService.findAllUsers();
    }

    public Users getUserById(Long id) {
        System.out.println("getUserById detail here: " + id);
        return userService.findUserById(id);
    }

    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
//        addMessage("User Deleted!");
//        return "redirect:/useroverview.xhtml";
    }

    public String updateUser(Users user) {
        this.user = user;
        System.out.println("users details here: " + this.user.getFirstName() + ' ' + user.getFirstName());
        System.out.println(user.getLastName());
        return "userupdate";
    }


    public void createUser() {
//        userService.createUser("tamim", "asdf", "asdf@fds.com","tel","asdff",date,true,"tamim");
        userService.createUser(newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob, enabled, username);
        addMessage("User toegevoegd!");
        clearForm();
    }

//    public String createOrUpdateUser() {
//        if (userId == 0 ) {
//            userService.createUser(newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob);
//            addMessage("User toegevoegd!");
//        } else {
//            userService.updateUser(userId, newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob);
//            addMessage("User updated!");
//        }
//        clearForm();
//        addMessage("The requested action is done! ");
//        return "redirect:/customer/list";
//    }

    private void clearForm() {
        newUserFirstName = null;
        newUserLastName = null;
        newUserEmail = null;
        newUserTel = null;
        newUserPassword = null;
        newUserDob = null;
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Users getUser() {
        return user;
    }

    public void setUsers(Users user) {
        this.user = user;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setUserService(UsersService userService) {
        this.userService = userService;
    }
}
