package com.realdolmen.thomasmore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SupportTicket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private int customerId;

    @ManyToOne
    private User customer;
    //private int supportId;
    @ManyToOne
    private User support;

    private String subject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSupportId() {
        return supportId;
    }

    public void setSupportId(int supportId) {
        this.supportId = supportId;
    }*/

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getSupport() {
        return support;
    }

    public void setSupport(User support) {
        this.support = support;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
