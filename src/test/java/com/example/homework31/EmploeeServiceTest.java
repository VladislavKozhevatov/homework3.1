package com.example.homework31;

import com.example.homework31.Model.Employee;
import com.example.homework31.Service.DepartmentService;
import com.example.homework31.Service.EmployeeService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;



public class EmploeeServiceTest {


    private final EmployeeService employeeService = new EmployeeService();


    @BeforeEach
    public void setUp(){


    }

    @Test
    public void getAllEmployees(){

        //создаем тестовые данные


        final Employee employee1 = new Employee("Петров_Владимир",2,35000);
        final Employee employee2 = new Employee("Егоров_Александр",1,55000);
        final Employee employee3 = new Employee("Антонов_Вадим",3,48000);

        //создаем список expected и заполняем его данными нашего метода
         List<Employee> expected = employeeService.getAllEmployee();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологиаем метод должен вернуть

        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        ////запускаем тест, в случае если список expected и actual не будут равны
        ////тест будет провален, о результатах теста читаем в консоли
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void correctAddEmployee(){
        //given
        Employee employeeToAdd = new Employee("Сырников Вячеслав Петрович",2,35000);

        //when
        Employee addedEmplyee = employeeService.addEmployee(employeeToAdd.getFullName(),employeeToAdd.getDepartment(),employeeToAdd.getSalary());

        //then
        Assertions.assertEquals(employeeToAdd,addedEmplyee);

    }


    @Test
    public void findEmployee(){
        //given
        Employee employeeToFind = new Employee("Сырников Вячеслав Петрович",2,35000);

        //when
        Employee foundEmployee = employeeService.findEmployee(employeeToFind.getFullName());

        //then
        Assertions.assertEquals(employeeToFind,foundEmployee);
    }


    @Test
    public void removeEmployee(){
        //given
        Employee employeeToRemove = new Employee("Сырников Вячеслав Петрович",2,35000);

        //when
        Employee removedEmployee = employeeService.delete(employeeToRemove.getFullName());

        //then
        Assertions.assertEquals(employeeToRemove,removedEmployee);
    }







}

