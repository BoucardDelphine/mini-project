package fr.tse.applicationDistrib.controller;

import fr.tse.applicationDistrib.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.tse.applicationDistrib.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeRepository repo;

	@GetMapping(path = "/")
    public String home(Model model) {
    	return "homepage";
    }

	
	
}
