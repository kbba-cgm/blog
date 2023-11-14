package com.ojt.blog.bl.service;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.persistence.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    /**
     * <h2>registerPerson</h2>
     * <p>Person name is modified to uppercase and register person to DB</p>
     *
     * @param personDTO
     * @return void
     */
    void registerPerson(PersonDTO personDTO);

    /**
     * <h2>Get Person List</h2>
     * <p>Getting person data list from DB</p>
     *
     * @return void
     */
    List<PersonDTO> getPersonList();

    /**
     * <h2>Get Person List</h2>
     * <p>Getting person data list from DB</p>
     *
     * @return void
     */
    Page<Person> getPageablePersonList(Pageable pageable);
}
