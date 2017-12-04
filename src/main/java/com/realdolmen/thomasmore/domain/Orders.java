package com.realdolmen.thomasmore.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD:src/main/java/com/realdolmen/thomasmore/domain/Orders.java

    @ManyToOne
    private User user;
=======
    private Users user;
>>>>>>> Team_2:src/main/java/com/realdolmen/thomasmore/domain/Order.java


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD:src/main/java/com/realdolmen/thomasmore/domain/Orders.java
    public User getUser() {
=======


    public Users getUser() {
>>>>>>> Team_2:src/main/java/com/realdolmen/thomasmore/domain/Order.java
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
