package com.example.homework31;

import com.example.homework31.Model.Employee;
import com.example.homework31.Service.DepartmentService;
import com.example.homework31.Service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    private final List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        employees.add(new Employee("Петров_Владимир",2,30000));
        employees.add(new Employee("Егоров_Александр",1,50000));
        employees.add(new Employee("Антонов_Вадим",3,40000));
    }

    @Test
    public void shouldCorrectlyCalculateSalarySum(){
        //given
        int departmentId =1;
        int expectedSum = 50000;


        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);
        //when
        int actualSum = departmentService.getSumSalariesByDep(departmentId);

        //then
        Assertions.assertEquals(expectedSum,actualSum);
    }


    @Test
    public void shouldCorrectlyFindEmployeeWithMinSalary(){
        //given
        int departmentId =2;
        int expectedMinSalaryByDep = employees.get(0).getSalary();

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
        int expectedMaxSalaryByDep = employees.get(1).getSalary();

        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);
        //when
        Integer actualMaxSalaryByDep = departmentService.getMaxSalaryInDep(departmentId);

        //then
        Assertions.assertEquals(expectedMaxSalaryByDep,actualMaxSalaryByDep);
    }

    @Test
    public void shouldCorrectlyFindEmployeesByDepartmentId(){
        //given

        Map<Integer,List<Employee>> expectedEmployee = new HashMap<>();
        expectedEmployee.put(1,new ArrayList<>(List.of(employees.get(1))));
        expectedEmployee.put(2,new ArrayList<>(List.of(employees.get(0))));
        expectedEmployee.put(3,new ArrayList<>(List.of(employees.get(2))));

        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);
        //when
        Map<Integer, List<Employee>> actualEmployees = departmentService.getAllEmployeesByDepartments();

        //then
        Assertions.assertEquals(expectedEmployee,actualEmployees);
    }
}
