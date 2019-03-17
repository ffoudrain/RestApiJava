package com.ffdev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffdev.models.People;
import com.ffdev.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired(required=true)
	private PeopleRepository peopleRepository;
	
	@Override
	public List<People> findAll() {
		List<People> peoples = new ArrayList<People>();
		peopleRepository.findAll().forEach(peoples::add);
		return peoples;
	}

	@Override
	public People find(String id) {
		return null;
	}

}
