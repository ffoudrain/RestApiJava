package com.ffdev.services;


import java.util.List;

import com.ffdev.models.People;

public interface PeopleService {

	public List<People> findAll();
	
	public People find(String id);
	
}
