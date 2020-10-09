package com.roelee.demo.controller;

import com.roelee.demo.form.RegistrationForm;
import com.roelee.demo.model.Registration;
import com.roelee.demo.repository.RegistrationRepository;
import com.roelee.demo.validator.RegistrationFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationFormValidator registrationFormValidator;

    @GetMapping("/")
    public String main(Model model, RegistrationForm registrationForm) {

        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping("/")
    public String save(Model model, @Valid RegistrationForm registrationForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        registrationFormValidator.validate(registrationForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        Registration data = new Registration();
        BeanUtils.copyProperties(registrationForm, data);

        System.out.println(data.toString());

        registrationRepository.save(data);

        redirectAttributes.addFlashAttribute("flash", new String("save successfully"));

        return "redirect:/";
    }

}
