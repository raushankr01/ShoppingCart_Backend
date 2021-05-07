package com.shoppingzone.validator;

import com.shoppingzone.model.User;
import com.shoppingzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required Field");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Enter with 6 to 32 characters");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "UserName already taken");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required Field");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Password must vary between 6 to 32 Characters");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Password did not match");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobilenumber", "Required Field");
        if(user.getMobilenumber().toString().length()<10||user.getMobilenumber().toString().length()>10)
        {
            errors.rejectValue("mobilenumber", "Invalid Mobile Number! Enter 10 digits Number");
        }

        if(userService.findByMobileNumber(user.getMobilenumber()) !=null) {
            errors.rejectValue("mobilenumber", "Mobile Number already registered");
        }
    }
}
