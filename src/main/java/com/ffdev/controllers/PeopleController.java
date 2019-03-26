package com.ffdev.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    //les valeurs sont passées dans l'url
    @RequestMapping(value = "/add", method = RequestMethod.POST,
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void addPeople(@RequestParam String firstname, @RequestParam String lastname, @RequestParam Integer age) {
        People p = new People();
        p.setFirstName(firstname);
        p.setLastName(lastname);
        Integer ageC = Integer.valueOf(age);
        p.setAge(ageC);
        peopleService.saved(p);
    }

    //les valeurs sont passées en JSON
    @RequestMapping(value = "/addp", method = RequestMethod.POST,
        consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public void addPeoples(@RequestBody People p) {
        peopleService.saved(p);
    }

    // delete people by id
    @GetMapping(path = "/delete/{id}")
    public void delete (@PathVariable Integer id) {
        try{
            peopleService.delete(id);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    @GetMapping(path = "/count")
    public String count() {
        return peopleService.count().toString();
    }
}
