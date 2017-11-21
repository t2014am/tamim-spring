package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.Orders;
import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public Orders createOrder(User user) {
        System.out.println("CREATING ORDER");
        Orders orders = new Orders();
        orders.setUser(user);
        ordersRepository.save(orders);
        return orders;
    }

    private Orders findOrderById(long id){
        return ordersRepository.findOrderById(id);
    }
}
