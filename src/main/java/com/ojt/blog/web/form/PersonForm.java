package com.ojt.blog.web.form;

import com.ojt.blog.bl.dto.PersonDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonForm {
    @NotEmpty(message = "Person\'s name must not be empty*******************!")
    String name;

    public PersonForm(PersonDTO personDTO) {
        setName(personDTO.getName());
    }
}
