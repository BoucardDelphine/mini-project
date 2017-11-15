package fr.tse.applicationDistrib.controller;

import java.util.List;

import org.json.JSONException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.applicationDistrib.dto.EmployeeDTO;
import fr.tse.applicationDistrib.entity.Employee;
import fr.tse.applicationDistrib.repository.EmployeeRepository;

@RestController
public class SalaryRestController {
	@Autowired
	EmployeeRepository repo;

	@RequestMapping(path = "/salaries-json",method = RequestMethod.POST)
    public List<EmployeeDTO> consumeJson() throws JSONException {
		ModelMapper modelMapper = new ModelMapper();
		List<Employee> employee = repo.findAllByOrderBySalaryAsc();
	    // Define the target type
	    java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDTO>>() {}.getType();
	    List<EmployeeDTO> employeeDTO = modelMapper.map(employee, targetListType);
    	return employeeDTO;
    }
	
}
