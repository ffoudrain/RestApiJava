package com.ffdev.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ffdev.models.People;
import com.ffdev.services.PeopleServiceImpl;

@RestController
@RequestMapping("/people")
public class PeopleController {

	@Autowired(required=true)
	private PeopleServiceImpl peopleService;
	
	@GetMapping(path="/all")
	public Iterable<People> listPeople(){
		return peopleService.findAll();
		
	}
	@GetMapping(path="/{id}")
	public Optional<People> find(@PathVariable Integer id) {
		return peopleService.find(id);
	}
}
