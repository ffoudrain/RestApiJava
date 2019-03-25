package com.ffdev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Optional<People> find(Integer id) {
		return peopleRepository.findById(id);
	}

    @Override
    public People saved(People people ) {
        return peopleRepository.save(people);
    }

    @Override
    public void delete(Integer id) {
        try {
            Optional<People> optinalPeople = peopleRepository.findById(id);
            People p = optinalPeople.get();  
            peopleRepository.delete(p);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Long count()
    {
		return peopleRepository.count();  
    }
}
