package org.example;

import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepositoryStub(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public boolean save(Employee e) {
    return false;
    }
}
