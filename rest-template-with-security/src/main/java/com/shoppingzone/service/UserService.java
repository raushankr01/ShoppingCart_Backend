package com.shoppingzone.service;

import com.shoppingzone.model.User;

public interface UserService {

    void save(User user);
    User findByUsername(String username);
    User findByMobileNumber(long mobilenumber);
}
