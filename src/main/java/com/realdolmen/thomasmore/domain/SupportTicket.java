package com.realdolmen.thomasmore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SupportTicket implements Serializable {


    @OneToMany (mappedBy="supportTicket")
    private List<Message> messageSupportTickets = new ArrayList<Message>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private int customerId;

    @ManyToOne
    private Users customer;
    //private int supportId;
    @ManyToOne
    private Users support;

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

    public Users getCustomer() {
        return customer;
    }

    public void setCustomer(Users customer) {
        this.customer = customer;
    }

    public Users getSupport() {
        return support;
    }

    public void setSupport(Users support) {
        this.support = support;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
