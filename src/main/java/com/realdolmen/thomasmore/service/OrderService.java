package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.domain.Order;
import com.realdolmen.thomasmore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public void createOrder(User user) {
        Order order = new Order();
        order.setUser(user);
        orderRepository.save(order);
    }
}
