package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.service.UserService;
import org.springframework.web.servlet.view.RedirectView;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

/**
 * Created by JUZAU33 on 28/09/2017.
 */
@ManagedBean
@SessionScoped
public class UserController {

    //Autowired kunnen we niet gebruiken in JSF, daarom gebruiken we hier dit om een spring bean te injecteren.
    @ManagedProperty("#{userService}")
    private UserService userService;

    private Long userId = new Long(0);
    private String newUserFirstName;
    private String newUserLastName;
    private String newUserEmail;
    private String newUserTel;
    private String newUserPassword;
    private Date newUserDob;
    private Date newUserGender;

    private User user;


    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    public User getUserById(Long id) {
        System.out.println("getUserById detail here: " + id);
        return userService.findUserById(id);
    }

<<<<<<< HEAD
    public void deleteUserById(Long id) {
=======
    public User getUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    public String deleteUserById(Long id) {
>>>>>>> 555661cb4c18393b99839c7681dfe93092726e05
        userService.deleteUserById(id);
//        addMessage("User Deleted!");
//        return "redirect:/useroverview.xhtml";
    }

    public String updateUser(User user) {
        this.user = user;
        System.out.println("user details here: " + this.user.getFirstName() +  ' ' + user.getFirstName());
        System.out.println(user.getLastName());
        return "userupdate";
    }


//    public void createUser() {
//        userService.createUser(newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob);
//        addMessage("User toegevoegd!");
//        clearForm();
//    }

    public String createOrUpdateUser() {
        if (userId == 0 ) {
            userService.createUser(newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob);
            addMessage("User toegevoegd!");
        } else {
            userService.updateUser(userId, newUserFirstName, newUserLastName, newUserEmail, newUserTel, newUserPassword, newUserDob);
            addMessage("User updated!");
        }
        clearForm();
        addMessage("The requested action is done! ");
        return "redirect:/customer/list";
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Deze setter MOET aanwezig zijn, anders kan spring deze service niet injecteren.
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
