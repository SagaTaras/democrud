package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employees = employeeService.findAll();
        theModel.addAttribute("employees", employees);
        return "/employees/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee employee = new Employee();
        theModel.addAttribute("employee", employee);
        return "employees/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        Employee employee = employeeService.findById(theId);
        theModel.addAttribute("employee", employee);
        return "employees/form";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";

    }
}
