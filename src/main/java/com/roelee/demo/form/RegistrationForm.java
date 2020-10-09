package com.roelee.demo.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationForm {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String mobileNumber;

    @NotEmpty
    @Email
    private String email;

    private String gender;
}
