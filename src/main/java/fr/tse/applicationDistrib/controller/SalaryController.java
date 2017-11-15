package fr.tse.applicationDistrib.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.tse.applicationDistrib.dto.EmployeeDTO;
import fr.tse.applicationDistrib.entity.Employee;
import fr.tse.applicationDistrib.repository.EmployeeRepository;

@Controller
public class SalaryController {

	@Autowired
	EmployeeRepository repo;

	@GetMapping(path = "/salaries")
    public String showEmployeeBySalary(Model model) throws JSONException {
		ModelMapper modelMapper = new ModelMapper();
		List<Employee> employee = repo.findAllByOrderBySalaryAsc();
	    // Define the target type
	    java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDTO>>() {}.getType();
	    List<EmployeeDTO> employeeDTO = modelMapper.map(employee, targetListType);
		model.addAttribute("listEmployee", employeeDTO);
    	return "/salary/salaries";

    }
	
}
