package com.example.homework31.Controller;


import com.example.homework31.Model.Employee;
import com.example.homework31.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee (@RequestParam String fullName , @RequestParam int department, @RequestParam int salary){
        Employee employee = new Employee(fullName,department,salary);
        employeeService.addEmployee(fullName,department,salary);
        return employee;
    }

     @GetMapping("/remove")
    public Employee remove(@RequestParam String fullName){
        return employeeService.delete(fullName);
    }

    @GetMapping ("/find")
    public  Employee find (String fullName){
        return employeeService.findEmployee(fullName);
    }




}
