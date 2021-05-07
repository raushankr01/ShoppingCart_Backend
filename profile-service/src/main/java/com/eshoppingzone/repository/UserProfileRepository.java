package com.eshoppingzone.repository;

import com.eshoppingzone.pojo.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile , Integer> {

    UserProfile findAllByMobileNumber(long mobileNumber);
    UserProfile findByFullName(String username);
}
