package com.example.homework31.Service;


import com.example.homework31.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getAllEmployees(){  // получить всех сотрудников с группировкой по департаменту
        List <Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Integer getSumSalariesByDep (Integer department){   //сумма зп сотрудников по департаменту
        List<Employee> employees = employeeService.getAllEmployee();
        return (Integer) employees.stream()
                .filter(employee -> employee.getDepartment() == department)
             //   .map(value -> value.getSalary())
                .mapToInt(Employee::getSalary)
                .sum();


    }

    public int getMaxSalaryInDep (Integer department){  // Поиск самой высокой ЗП среди сотрудников по департаментам
        List<Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(value -> value.getSalary())
                .max()
                .orElse(0);
    }



    public int getMinSalaryInDep (Integer department){  // Поиск самой низкой ЗП среди сотрудников по департаментам
        List<Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(value -> value.getSalary())
                .min()
                .orElse(0);
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartments (){
        List <Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
