package com.ffdev.services;


import java.util.List;
import java.util.Optional;

import com.ffdev.models.People;

public interface PeopleService {

	public List<People> findAll();

	public Optional<People> find(Integer id);

    public People saved(People people );

    public void delete(Integer id);

    public Long number();
}
