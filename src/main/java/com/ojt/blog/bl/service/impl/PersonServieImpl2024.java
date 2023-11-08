package com.ojt.blog.bl.service.impl;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.bl.service.PersonService;
import com.ojt.blog.persistence.entity.Person;
import com.ojt.blog.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class PersonServieImpl2024 implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public void registerPerson(PersonDTO personDTO) {
        // person (entity) ----> repository
        String modifiedName = personDTO.getName().toLowerCase();
        personDTO.setName(modifiedName);
        Person person = new Person(personDTO);
        personRepository.save(person);
    }
}
