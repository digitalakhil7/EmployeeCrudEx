package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.entity.Employee;
import com.tcs.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	@PostMapping("/register")
	public String showRegisterPage(@ModelAttribute Employee employee, Model model) {
		Integer id = service.saveEmployee(employee);
		model.addAttribute("msg","Employee '"+id+"' created");
		System.out.println(employee);
		return "EmployeeRegister";
	}
	
	@GetMapping("/all")
	public String showAll(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id,Model model) {
		service.deleteOneEmployee(id);
		model.addAttribute("msg", "Employee '"+id+"' deleted");
		return "EmployeeData";
	}
	@GetMapping("/edit")
	public String editEmployee(@RequestParam Integer id,Model model) {
		Employee e = service.editOneEmployee(id);
		model.addAttribute("employee", e);
		return "EmployeeEdit";
	}
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		service.saveEmployee(employee);
		return "redirect:all";
	}
}
