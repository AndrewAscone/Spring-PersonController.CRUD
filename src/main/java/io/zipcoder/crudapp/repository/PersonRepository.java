package io.zipcoder.crudapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.zipcoder.crudapp.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    
}
