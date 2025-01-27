package com.example.homework31.Controller;

import com.example.homework31.Model.Employee;
import com.example.homework31.Service.DepartmentService;
import com.example.homework31.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("{id}/employees")
    public Map<Integer, List<Employee>> getAllEmployeesByDep (@PathVariable int id){
        return departmentService.getAllEmployees();
    }

    @GetMapping("/{id}/salary/sum")
    public int getSumSalariesByDep (@PathVariable int id , Integer department){
        return departmentService.getSumSalariesByDep(department);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryByDep (@PathVariable int id ,Integer department){
        return departmentService.getMaxSalaryInDep(department);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalaryByDep (@PathVariable int id , Integer department){
        return departmentService.getMinSalaryInDep(department);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesByDep (){
        return departmentService.getAllEmployeesByDepartments();
    }


}
