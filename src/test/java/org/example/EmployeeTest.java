package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmployeeTest {
    Employee employee = new Employee("1", 50000);

    @Test
    void updateIdShouldReturnTwo() {

        employee.setId("2");
        var result = employee.getId();

        assertThat(result).isEqualTo("2");
    }

    @Test
    void getIdShouldReturnOne() {
        var result = employee.getId();

        assertThat(result).isEqualTo("1");
    }


    @Test
    void updateSalaryShouldReturnSixtyThousand() {

        employee.setSalary(60000.00);

        double result = (employee.getSalary());

        assertThat(result).isEqualTo(60000.0);
    }

    @Test
    void getIdForEmployee() {

        var result = employee.getId();

        assertThat(result.equals("1"));

    }

    @Test
    void testToStringMethod() {

        var result = employee.toString();

        assertThat(result).isEqualTo("Employee [id=1, salary=50000.0]");
    }

    @Test
    void getSalaryForEmployee() {

        var result = employee.getSalary();

        assertThat(result).isEqualTo(50000);

    }

    @Test
    void checkWhetherEmployeeIsBeingPaid() {

        boolean result = employee.isPaid();

        assertThat(result).isFalse();

    }

    @Test
    void check_if_test_is_updated_when_set_paid_is_called() {

        employee.setPaid(true);
        var result = employee.isPaid();

        assertThat(result).isTrue();
    }

}