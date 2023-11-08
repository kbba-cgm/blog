package com.ojt.blog.web.controller;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.bl.service.PersonService;
import com.ojt.blog.persistence.entity.Person;
import com.ojt.blog.web.form.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    /**
     * <h2>Register Page</h2>
     * <p>Show form for person registration</p>
     *
     * @param model
     * @return String
     */
    @GetMapping("/create")
    public String registerPage(Model model) {
        model.addAttribute("person", new PersonForm());
        return "person/create";
    }

    /**
     * <h2>Register Person</h2>
     * <p>pass person data to service</p>
     *
     * @param model
     * @param person
     * @return String
     */
    @PostMapping("/create")
    public String registerPerson(Model model, @ModelAttribute PersonForm person) {
        PersonDTO personDTO = new PersonDTO(person);
        personService.registerPerson(personDTO);
        // personDTO --> service
        return "redirect:/";
    }
}
