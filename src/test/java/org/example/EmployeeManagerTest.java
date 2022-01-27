package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void employeeIsPaid() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        Employee emp1 = new Employee(anyString(), 30000);
        assertThat(emp1.isPaid());
    }



}