package com.ojt.blog.persistence.repository;

import com.ojt.blog.persistence.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public void updatePersonByTime();
}
