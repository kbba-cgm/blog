package com.ojt.blog.bl.service.impl;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.bl.service.PersonService;
import com.ojt.blog.persistence.entity.Person;
import com.ojt.blog.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("personService")
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

    /**
     * <h2>Get Person List</h2>
     * <p>Getting person data list from DB</p>
     *
     * @return void
     */
    public List<PersonDTO> getPersonList() {
        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = personList.stream().map(person -> new PersonDTO(person)).toList();
        return personDTOList;
    }

    @Override
    public Page<Person> getPageablePersonList(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
