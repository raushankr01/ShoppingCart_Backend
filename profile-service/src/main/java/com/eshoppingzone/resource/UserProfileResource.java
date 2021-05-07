package com.eshoppingzone.resource;


import com.eshoppingzone.pojo.UserProfile;
import com.eshoppingzone.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/profiles")
public class UserProfileResource {

    @Autowired
    private UserProfileServiceImpl userProfileService;

    // Adding a new Customer Profile
    @PostMapping("/addCustomer") // Done JUnit5 Test
    public UserProfile addNewCustomerProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.addNewCustomerProfile(userProfile);
    }

    // Adding a new Merchant Profile
    @PostMapping("/addMerchant") // Done JUnit5 Test
    public void addNewMerchant(@RequestBody UserProfile userProfile) {
        userProfileService.addNewMerchantProfile(userProfile);
    }

    // Adding a new Delivery Agent Profile
    @PostMapping("/addDeliveryAgent")  //Done JUnit5 Test
    public void addNewDeliveryAgent(@RequestBody UserProfile userProfile) {
        userProfileService.addNewDeliveryAgentProfile(userProfile);
    }

    // Getting all Profiles (Customer + Merchants + Delivery Agents)
    @GetMapping("/allProfiles") // Done JUnit5 Test
    public List<UserProfile> getAllProfiles() {
        return  userProfileService.getAllProfiles();
    }

    // Getting a Single Profile based on Profile ID
    @GetMapping("/profile/{id}") // Done JUnit5 Test
    public UserProfile getProfileById(@PathVariable("id") int id) {
        return userProfileService.getByProfileId(id);
    }

    // Getting a Single Profile based on Mobile Number
    @GetMapping("/mobileNumber/{mobile}") // Done JUnit5 Test
    public UserProfile getProfileByMobile(@PathVariable("mobile") long mobile) {
        return userProfileService.findByMobileNumber(mobile);
    }

    // Getting a Single Profile based on Full Name
    @GetMapping("/username/{username}") // Done JUnit5 Test
    public UserProfile getProfileByUserName(@PathVariable("username") String username) {
        return userProfileService.getByUserName(username);
    }

    // Updating a User Profile
    @PutMapping("/updateProfile")
    public void updateProfile(@RequestBody UserProfile userProfile) {
        userProfileService.updateProfile(userProfile);
    }

    // Deleting a User Profile based on Profile ID
    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable("id") int id) {
        userProfileService.deleteProfile(id);
    }
}
