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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
    private String newUserFirstName;



    private String newUserLastName;
    private String newUserEmail;
    private String newUserTel;
    private String newUserPassword;
    private Date newUserDob;
    private Date newUserGender;
    private String newAddress;
    private String newPostalCode;
    private String newCity;
    private String newState;
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
    public String toUpdatePage(Long id) {
        user = userService.findUserById(id);
        addMessage("update username" + user.getUsername());
        return "userupdate?faces-redirect=true";
    }
    public String toUpdatePageName(String username) {
        user = userService.findUserByUsername(username);
        addMessage("update username" + user.getUsername());
        return "productupdate?faces-redirect=true";
    }
    public String updateUser(Users user) {
        this.user = user;
        System.out.println("users details here: " + this.user.getFirstName() + ' ' + user.getFirstName());
        System.out.println(user.getLastName());

        userService.updateUser(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getTel(), user.getPassword(), user.getDob());
        addMessage("User updated!");

        return "userupdate";
    }


    public void createUser() {
//        userService.createUser("tamim", "asdf", "asdf@fds.com","tel","asdff",date,true,"tamim");
        userService.createUser(newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob, enabled, username,newAddress,newCity,newPostalCode,newState);
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
    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewPostalCode() {
        return newPostalCode;
    }

    public void setNewPostalCode(String newPostalCode) {
        this.newPostalCode = newPostalCode;
    }

    public String getNewCity() {
        return newCity;
    }

    public void setNewCity(String newCity) {
        this.newCity = newCity;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }
    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setUserService(UsersService userService) {
        this.userService = userService;
    }
}
