package com.ojt.blog.persistence.entity;

import com.ojt.blog.bl.dto.PersonDTO;
import com.ojt.blog.web.form.PersonForm;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Date createdAt;
    Date updatedAt;
    
    public Person(PersonDTO personDTO) {
        setName(personDTO.getName());
    }
}
