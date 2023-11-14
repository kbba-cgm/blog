package com.ojt.blog.web.controller;

import com.ojt.blog.bl.service.PersonService;
import com.ojt.blog.web.form.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    @Autowired
//    @Qualifier("personService2024")
//    PersonService personService;
    @GetMapping("/")
    public String registerPage() {
        return "home/index";
    }
}
