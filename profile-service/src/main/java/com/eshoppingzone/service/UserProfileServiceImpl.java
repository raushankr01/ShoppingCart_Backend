package com.eshoppingzone.service;

import com.eshoppingzone.exception.ResourceNotFoundException;
import com.eshoppingzone.pojo.Role;
import com.eshoppingzone.pojo.UserProfile;
import com.eshoppingzone.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile addNewCustomerProfile(UserProfile userProfile) {
        userProfile.setRole(Role.customer);
        return userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getByProfileId(int id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:- " + id));
    }


    @Override
    public void updateProfile(UserProfile userProfile) {
        UserProfile update = userProfileRepository.findById(userProfile.getProfileId()).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id:- " +userProfile.getProfileId()));
        update.setFullName(userProfile.getFullName());
        update.setRole(userProfile.getRole());
        update.setAbout(userProfile.getAbout());
        update.setGender(userProfile.getGender());
        update.setDateOfBirth(userProfile.getDateOfBirth());
        update.setEmailId(userProfile.getEmailId());
        update.setImage(userProfile.getImage());
        update.setMobileNumber(userProfile.getMobileNumber());
        update.setPassword(userProfile.getPassword());
        userProfileRepository.save(update);
    }

    @Override
    public void deleteProfile(int id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:- " + id));
        userProfileRepository.delete(userProfile);
    }

    @Override
    public void addNewMerchantProfile(UserProfile userProfile) {
        userProfile.setRole(Role.merchant);
        userProfileRepository.save(userProfile);
    }

    @Override
    public void addNewDeliveryAgentProfile(UserProfile userProfile) {
        userProfile.setRole(Role.deliveryAgent);
        userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findByMobileNumber(long mobileNumber) {
        return userProfileRepository.findAllByMobileNumber(mobileNumber);
    }

    @Override
    public UserProfile getByUserName(String username) {
        return userProfileRepository.findByFullName(username);
    }
}
