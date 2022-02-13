package org.example;

import java.util.List;

public interface EmployeeRepository {

	List<Employee> findAll();

	boolean save(Employee e);
}
