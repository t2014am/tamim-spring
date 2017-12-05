package com.realdolmen.thomasmore.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Users user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {

        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
