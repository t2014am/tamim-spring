package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.Orders;
import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.domain.User;
import com.realdolmen.thomasmore.service.OrderProductService;
import com.realdolmen.thomasmore.service.OrdersService;
import com.realdolmen.thomasmore.service.UserService;
import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class OrderController {

    @ManagedProperty("#{ordersService}")
    private OrdersService ordersService;

    @ManagedProperty("#{orderProductService}")
    private OrderProductService orderProductService;

    @ManagedProperty("#{userService}")
    private UserService userService;

    private Orders order;
    private Long orderId = null;


    public void addProductToOrder(long id){
        if (orderId == null) {
            User user = userService.findUserByEmail("tamim@asefi.com");
            order = ordersService.createOrder(user);
            System.out.println("NEW ORDER CREATED");
        }
        orderProductService.createNewOrderProduct(order, id);
        System.out.println("NEW ORDER CREATED WITH PRODUCT");
    }

    public List<Product> getAllProductsOrder() {
        return orderProductService.findAllProducts(order.getId());
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public void setOrderProductService(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
