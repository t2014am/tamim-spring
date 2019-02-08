package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.Orders;
import com.realdolmen.thomasmore.domain.Users;
import com.realdolmen.thomasmore.repository.OrderProductRepository;
import com.realdolmen.thomasmore.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;

    public Orders createOrder(Users user) {
        System.out.println("CREATING ORDER");
        Orders orders = new Orders();
        orders.setUser(user);
        ordersRepository.save(orders);
        return orders;
    }

    private Orders findOrderById(long id){
        return ordersRepository.findOrderById(id);
    }

    @Transactional
    public void clearShoppingCart(long id) {
        orderProductRepository.removeAllByOrderId(id);
        ordersRepository.delete(id);
    }
}
