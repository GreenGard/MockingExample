package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.returns;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryStub(List.of(
            new Employee("1", 50000),
            new Employee("2", 30000)));
    BankService bankService = mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

    @Test
    void throwExceptionWhenEmpty() {

        doThrow(new RuntimeException()).when(bankService).pay(anyString(), anyDouble());

        employeeManager.payEmployees();

        assertThat(employeeRepository.findAll().get(0).isPaid()).isFalse();


    }

    @Test
    @Disabled
    void findAllEmployees() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);

        Employee emp1 = new Employee("1", 30000);
        Employee emp2 = new Employee("2", 20000);
        List<Employee> Employees = List.of(emp1, emp2);


    }

    @Test
    void employeeGetTheRightSalary() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        Employee emp1 = new Employee(anyString(), 30000);
        Employee emp2 = new Employee(anyString(), 20000.0);
        var result = Double.valueOf(emp1.getSalary());
        assertEquals(30000, result);
    }

    @Test
    void employeeIsPaid() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        Employee emp1 = new Employee(anyString(), 30000);
        assertThat(emp1.isPaid());
    }
}