package com.realdolmen.thomasmore.service;

import com.realdolmen.thomasmore.domain.OrderProduct;
import com.realdolmen.thomasmore.domain.Product;
import com.realdolmen.thomasmore.repository.OrderProductRepository;
import com.realdolmen.thomasmore.repository.OrdersRepository;
import com.realdolmen.thomasmore.repository.ProductRepository;
import com.realdolmen.thomasmore.domain.Orders;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    public void createNewOrderProduct(Orders order, long productId) {
        OrderProduct orderProduct = new OrderProduct();
        if (orderProductRepository.getOrderProductByProductId(productId) != null){
            orderProduct = orderProductRepository.getOrderProductByProductId(productId);
            orderProduct.setNumber(orderProduct.getNumber() + 1);
        } else {
            orderProduct.setOrder(order);
            orderProduct.setProduct(productRepository.findProductById(productId));
            orderProduct.setNumber(1);
        }
        orderProductRepository.save(orderProduct);
    }

    public List<Product> findAllProducts(long id){
        List<OrderProduct> orderProducts = orderProductRepository.findOrderProductByOrderId(id);
        List<Product> products = new ArrayList<Product>();

        for (int i = 0; i < orderProducts.size(); i++){
            products.add(productRepository.findProductById(orderProducts.get(i).getProduct().getId()));

        }
        return products;
    }

}
