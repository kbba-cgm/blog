package com.ojt.blog.bl.service;

import com.ojt.blog.bl.dto.PersonDTO;

public interface PersonService {
    /**
     * <h2>registerPerson</h2>
     * <p>Person name is modified to uppercase and register person to DB</p>
     *
     * @param personDTO
     * @return void
     */
    void registerPerson(PersonDTO personDTO);
}
