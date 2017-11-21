package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
    Orders findOrderById(long id);
}
