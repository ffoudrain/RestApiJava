package com.ffdev.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(path="/add/{lName}/{fName}/{age}") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String lName
			, @RequestParam String fName, @RequestParam String age) {
        try{
            People p = new People();
            p.setLastName(lName);
            p.setFirstName(fName);
            p.setAge(Integer.valueOf(age));
            peopleService.saved(p);

        }
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
        return "Saved";
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
