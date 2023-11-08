package com.ojt.blog.bl.service.impl;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.bl.service.PersonService;
import com.ojt.blog.persistence.entity.Person;
import com.ojt.blog.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    /**
     * <h2>registerPerson</h2>
     * <p>Person name is modified to uppercase and register person to DB</p>
     *
     * @param personDTO
     * @return void
     */
    @Override
    public void registerPerson(PersonDTO personDTO) {
        // person (entity) ----> repository
        String modifiedName = personDTO.getName().toUpperCase();
        personDTO.setName(modifiedName);
        Person person = new Person(personDTO);
        personRepository.save(person);
    }
}
