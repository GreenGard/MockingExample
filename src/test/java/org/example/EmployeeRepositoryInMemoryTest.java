package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryInMemoryTest {


    @Test
    void shouldReturnEmptyList() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryInMemory();

        var result = employeeRepository.findAll().size();

        assertThat(result).isZero();
    }

    @Test
    void whenSavingEmployeeWithExistingIdShouldNotChangeSize() {
        EmployeeRepositoryInMemory employeeRepositoryInMemory = new EmployeeRepositoryInMemory();

        employeeRepositoryInMemory.save(new Employee("MA", 40000.0));
        int amountOfEmployeesBeforeSave = employeeRepositoryInMemory.findAll().size();
        employeeRepositoryInMemory.save(new Employee("MA", 45000.0));

        assertEquals(amountOfEmployeesBeforeSave, employeeRepositoryInMemory.findAll().size());
    }

    @Test
    void whenSavingEmployeeWithExistingIdShouldReplaceOldEmployee() {
        EmployeeRepositoryInMemory employeeRepositoryInMemory = new EmployeeRepositoryInMemory();

        employeeRepositoryInMemory.save(new Employee("MA", 40000.0));
        employeeRepositoryInMemory.save(new Employee("MA", 45000.0));

        assertEquals(45000, employeeRepositoryInMemory.employees.get(0).getSalary());

    }

    @Test
    void whenSavingEmployeeWithUniqueIdShouldChangeSize() {
        EmployeeRepositoryInMemory employeeRepositoryInMemory = new EmployeeRepositoryInMemory();

        employeeRepositoryInMemory.save(new Employee("MA", 40000.0));
        int amountOfEmployeesBeforeSave = employeeRepositoryInMemory.findAll().size();
        employeeRepositoryInMemory.save(new Employee("AM", 45000.0));
        assertNotEquals(amountOfEmployeesBeforeSave, employeeRepositoryInMemory.findAll().size());
    }

    @Test
    void whenInitializingWithListShouldHaveSizeGreaterThanZero() {
        ArrayList<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("HH", 20000.0));
        }};
        EmployeeRepositoryInMemory employeeRepositoryInMemory = new EmployeeRepositoryInMemory(employees);
        assertTrue(employeeRepositoryInMemory.employees.size()>0);
    }

}
