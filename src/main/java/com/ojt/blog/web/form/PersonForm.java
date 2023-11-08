package com.ojt.blog.web.form;

import com.ojt.blog.bl.dto.PersonDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonForm {
    String name;

    public PersonForm(PersonDTO personDTO) {
        setName(personDTO.getName());
    }
}
