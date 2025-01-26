package com.example.homework31;

import com.example.homework31.Model.Employee;
import com.example.homework31.Service.DepartmentService;
import com.example.homework31.Service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {


    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;


//    private final Map<String, Employee> employees = new HashMap<>(){{
//        put("СырниковАнтон",new Employee("СырниковАнтон",1,20000));
//        put("СырниковАнтон1",new Employee("СырниковАнтон1",1,30000));
//        put("СырниковАнтон2",new Employee("СырниковАнтон2",1,40000));
//    }};

    private final List<Employee> employees = new ArrayList<>(){
        Employee employee1 = new Employee("СырниковАнтон",1,20000);
        Employee employee2 = new Employee("СырниковАнтон1",1,30000);
        Employee employee3 = new Employee("СырниковАнтон2",1,40000);
    };

    @Test
    public void shouldCorrectlyCalculateSalarySum(){
        //given
        int departmentId =1;
        int expectedSum = 90000;

        employeeService.addEmployee("СырниковАнтон",1,20000);
        employeeService.addEmployee("СырниковАнтон1",1,30000);
        employeeService.addEmployee("СырниковАнтон2",1,40000);


        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);
        //when
        int actualSum = departmentService.getSumSalariesByDep(departmentId);

        //then
        Assertions.assertEquals(expectedSum,actualSum);
    }


    @Test
    public void shouldCorrectlyFindEmployeeWithMinSalary(){
        //given
        int departmentId =1;
        Employee expectedMinSalaryByDep = employees.get(1);

        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);
        //when
        Integer actualMinSalaryBydep = departmentService.getMinSalaryInDep(departmentId);

        //then
        Assertions.assertEquals(expectedMinSalaryByDep,actualMinSalaryBydep);
    }


    @Test
    public void shouldCorrectlyFindEmployeeWithMaxSalary(){
        //given
        int departmentId =1;
        Employee expectedMaxSalaryByDep = employees.get(departmentId);

        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);
        //when
        Integer actualMaxSalaryByDep = departmentService.getMaxSalaryInDep(departmentId);

        //then
        Assertions.assertEquals(expectedMaxSalaryByDep,actualMaxSalaryByDep);
    }

//    @Test
//    public void shouldCorrectlyFindEmployeesByDepartmentId(){
//        //given
//        int departmentId =1;
//        List<Employee> expectedEmployee = (List<Employee>) employees.values();
//
//        Mockito.when(employeeService.getAllEmployee()).thenReturn((List<Employee>) employees);
//        //when
//        List<Employee> actualEmployees = departmentService.getAllEmployeesByDepartments(departmentId);
//
//        //then
//        Assertions.assertEquals(expectedEmployee,actualEmployees);
//    }


}
