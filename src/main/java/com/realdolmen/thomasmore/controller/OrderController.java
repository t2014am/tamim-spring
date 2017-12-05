package com.realdolmen.thomasmore.controller;

import com.realdolmen.thomasmore.domain.OrderProduct;
import com.realdolmen.thomasmore.domain.Orders;
import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.domain.Users;
import com.realdolmen.thomasmore.service.OrderProductService;
import com.realdolmen.thomasmore.service.OrdersService;
import com.realdolmen.thomasmore.service.ProductService;
import com.realdolmen.thomasmore.service.UsersService;
import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;
import org.hibernate.criterion.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

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

    @ManagedProperty("#{usersService}")
    private UsersService usersService;

    @ManagedProperty("#{productService}")
    private ProductService productService;

    private Orders order;
    private Long orderId = null;
    private List<Product> products = null;
    private int totalPrice = 0;
    private int numberItems = 0;


    public void addProductToOrder(long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User loggedInUserObject = (User) principal;
        String username = loggedInUserObject.getUsername();
        Users loggedInUser = usersService.findUserByUsername(username);

        if (orderId == null) {
            order = ordersService.createOrder(loggedInUser);
            orderId = order.getId();
            System.out.println("NEW ORDER CREATED");
        }
        orderProductService.createNewOrderProduct(order, id);

        products = orderProductService.findAllProducts(orderId);
        System.out.println("PRODUCT ADDED TO ORDER");
    }

    public int getNumberOrderProduct(long id){
        OrderProduct orderProduct = orderProductService.getOrderProductByProductId(id);
        return orderProduct.getNumber();
    }

    public void deleteItemShoppingCart(long id){
        OrderProduct orderProduct = orderProductService.getOrderProductByProductId(id);
        if (orderProduct.getNumber() > 1) {
            orderProductService.lowerNumberOrderProduct(id, orderProduct.getNumber());
        } else {
            orderProductService.deleteOrderProduct(orderId, id);
            products = orderProductService.findAllProducts(orderId);
        }
    }

    public void clearShoppingCart(){
        ordersService.clearShoppingCart(orderId);
        products = orderProductService.findAllProducts(orderId);
        orderId = null;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public void setOrderProductService(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }


    public void setUsersService(UsersService userService) {
        this.usersService = userService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotalPrice() {
        totalPrice = 0;
        for (int i = 0; i < products.size(); i++){
            OrderProduct orderProduct = orderProductService.getOrderProductByProductId(products.get(i).getId());
            int number = orderProduct.getNumber();
            totalPrice += number * products.get(i).getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumberItems() {
        int numberItems = 0;
        if (products != null) {
            for (int i = 0; i < products.size(); i++){
                OrderProduct orderProduct = orderProductService.getOrderProductByProductId(products.get(i).getId());
                int number = orderProduct.getNumber();
                numberItems += number;
            }
        }
        return numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }
}
