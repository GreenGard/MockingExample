package org.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryInMemory implements EmployeeRepository {
    ArrayList<Employee> employees = new ArrayList<Employee>();
    public EmployeeRepositoryInMemory(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public EmployeeRepositoryInMemory() {

    }
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public boolean save(Employee e) {
        for (int i = 0; i < employees.size() ; i++) {
            if (employees.get(i).getId().equals(e.getId())) {
                employees.set(i,e);
                return false;
            }
        }
        employees.add(e);
        return true;
    }
}
