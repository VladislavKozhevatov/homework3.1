package com.example.homework31.Service;

import com.example.homework31.Model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService {

    Map<String,Employee> employees;

    public EmployeeService() {
        this.employees = new LinkedHashMap<>();
    }

    @PostConstruct
    public  void initEmployees(){
        addEmployee("Петров_Владимир",2,35000);
        addEmployee("Егоров_Александр",1,55000);
        addEmployee("Антонов_Вадим",3,48000);

    }

    public Employee addEmployee (String fullName, int department , int salary){
        if (employees.containsKey(fullName)){
            throw new IllegalArgumentException("Такой сотрудник уже добавлен");
        }
        Employee employee = new Employee(fullName,department,salary);
        employees.put(fullName,employee);
        return employee;
    }

    public Employee findEmployee(String fullName) {
        Employee employee = employees.get(fullName);
//        if (employee == null) {
//            throw new IllegalArgumentException("Сотрудника с таким именем нет");
//        }
        return employee;
    }

    public Employee delete(String fullName){
        Employee employee = employees.get(fullName);
        if (employee == null) {
            throw new IllegalArgumentException("Сотрудника с таким именем нет");
        }
       return employees.remove(fullName);
    }

    public List<Employee> getAllEmployee(){
       initEmployees();
       return new ArrayList<>(employees.values());
    }

//    public Map<String, Employee> getAllEmployee(){
//        return new HashMap<>(employees);
//    }

}
