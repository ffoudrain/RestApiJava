package com.ffdev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ffdev.models.People;

@Repository("peopleRepository")
public interface PeopleRepository extends CrudRepository<People, Integer> {

}
