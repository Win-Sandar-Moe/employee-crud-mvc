package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	// /edit-employee?id=1
	@GetMapping("/edit-employee")
	public String editEmployee(@RequestParam("id") long id, Model model) {
		model.addAttribute("employee", employeeService.findEmployeeById(id));
		return "employeeForm";
	}

	// localhost:8080/delete-employee?id=1
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam("id") long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}

	@RequestMapping("/")
	public String welcomPage(Model model) {
		model.addAttribute("employees", employeeService.listEmployee());
		return "employees";
	}

	/*
	 * 2 faces form 1. form object 2. render form
	 * 
	 * 1. valid form object 2. save object 3. redirect
	 */
	@PostMapping("/add-employee")
	public String saveEmployee(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "employeeForm";
		}
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/add-employee")
	public String employeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}

}
