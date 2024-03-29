package com.shoppingzone.model;

import java.time.LocalDate;
import java.util.List;

public class UserProfile {

    private int profileId;
    private String fullName;
    private String image;
    private String emailId;
    private Long mobileNumber;
    private List<Address> Addresses;
    private String about;
    private LocalDate dateOfBirth;
    private String gender;
    private String role;
    private String password;

    public UserProfile() {
    }

    public UserProfile(int profileId, String fullName, String image, String emailId, Long mobileNumber,
                       List<Address> addresses, String about, LocalDate dateOfBirth, String gender, String role,
                       String password) {
        super();
        this.profileId = profileId;
        this.fullName = fullName;
        this.image = image;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        Addresses = addresses;
        this.about = about;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.role = role;
        this.password = password;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Address> getAddresses() {
        return Addresses;
    }

    public void setAddresses(List<Address> addresses) {
        Addresses = addresses;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
