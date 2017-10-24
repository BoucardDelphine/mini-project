package fr.tse.applicationDistrib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path = "/")
    public String dbpediaRank(Model model) {
    	return "homepage";
    }
	
}
