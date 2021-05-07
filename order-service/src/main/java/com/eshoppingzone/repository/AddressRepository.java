package com.eshoppingzone.repository;

import com.eshoppingzone.orders.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends MongoRepository<Address , Integer> {

    List<Address> findByCustomerId(int customerId);
}
