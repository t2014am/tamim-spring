package com.realdolmen.thomasmore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private String password;
    private Date dob;
    private String gender;

    private String username = email;
    private boolean enabled = false;

    @OneToMany (mappedBy="customer")
    private List<SupportTicket> customerUserSupportTickets = new ArrayList<SupportTicket>();

    @OneToMany (mappedBy="support")
    private List<SupportTicket> supportUserSupportTickets = new ArrayList<SupportTicket>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<SupportTicket> getCustomerUserSupportTickets() {
        return customerUserSupportTickets;
    }

    public void setCustomerUserSupportTickets(List<SupportTicket> customerUserSupportTickets) {
        this.customerUserSupportTickets = customerUserSupportTickets;
    }

    public List<SupportTicket> getSupportUserSupportTickets() {
        return supportUserSupportTickets;
    }

    public void setSupportUserSupportTickets(List<SupportTicket> supportUserSupportTickets) {
        this.supportUserSupportTickets = supportUserSupportTickets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return email;
    }
}
