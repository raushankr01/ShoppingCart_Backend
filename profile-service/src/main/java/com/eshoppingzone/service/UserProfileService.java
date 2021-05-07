package com.eshoppingzone.service;

import com.eshoppingzone.pojo.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile addNewCustomerProfile(UserProfile userProfile);
    List<UserProfile> getAllProfiles();
    UserProfile getByProfileId(int id);
    void updateProfile(UserProfile userProfile);
    void deleteProfile(int id);
    void addNewMerchantProfile(UserProfile userProfile);
    void addNewDeliveryAgentProfile(UserProfile userProfile);
    UserProfile findByMobileNumber(long mobileNumber);
    UserProfile getByUserName(String username);
}
