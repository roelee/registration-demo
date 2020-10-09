package com.roelee.demo.validator;

import com.roelee.demo.form.RegistrationForm;
import com.roelee.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationFormValidator implements Validator {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        RegistrationForm form = (RegistrationForm) target;

        if (!errors.hasFieldErrors("mobileNumber")) {

            if (!form.getMobileNumber().startsWith("+62")) {
                errors.rejectValue("mobileNumber", "error.mobileNumber","please enter valid indonesia phone number");
            }

        }

    }
}
