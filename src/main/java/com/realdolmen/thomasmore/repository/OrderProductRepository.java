package com.realdolmen.thomasmore.repository;

import com.realdolmen.thomasmore.domain.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

    List<OrderProduct> findOrderProductByOrderId(long id);
}
