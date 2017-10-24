package fr.tse.applicationDistrib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.tse.applicationDistrib.repository.EmployeeRepository;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeRepository repo;

	@GetMapping(path = "/")
    public String dbpediaRank(Model model) {
    	return "homepage";
    }
	
}
