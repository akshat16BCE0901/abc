package com.akshat.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akshat.model.Employee;
import com.akshat.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@InitBinder("employee")
    public void customizeBinding (WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "date_of_birth",
                                    new CustomDateEditor(dateFormatter, true));
    }
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value="/addnew",method=RequestMethod.GET)
	public String addnewemployee(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "addNewEmployeeForm";
	}
	
	
	@RequestMapping(value="/submit_new",method=RequestMethod.POST)
	public String submitnewemployee(@ModelAttribute("employee") Employee employee,Model model) throws ParseException
	{
		employeeService.addEmployee(employee);
		return "success";
	}
	
	@RequestMapping(value="/displayAll",method=RequestMethod.GET)
	public String displayAll(Model model)
	{
		model.addAttribute("employeesList", employeeService.displayAll());
		System.out.println(model);
		return "displayemployees";
	}
	
}
