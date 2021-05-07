package com.eshoppingzone.repository;

import com.eshoppingzone.orders.Orders;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Orders , Integer> {

    List<Orders> findByCustomerId(int customerId);
    Orders findFirstByOrderByOrderIdDesc();
}
