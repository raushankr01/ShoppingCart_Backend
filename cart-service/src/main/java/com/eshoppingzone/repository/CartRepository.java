package com.eshoppingzone.repository;

import com.eshoppingzone.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart , Integer> {

    Cart findByCartId(int cartId);
}
