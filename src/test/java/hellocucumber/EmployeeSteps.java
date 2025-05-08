package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import dtu.example.Employee;

public class EmployeeSteps {
    private Employee employee;
    private String initials;

    @Given("an employee is created with initials {string}")
    public void anEmployeeExistsWithInitials(String string) {
        employee = new Employee(initials);
    }

    @Then("the employee exists in the Database")
    public void theEmployeeExistsInTheDatabase() {
        assertTrue(employee.employeeExists());
    }

    @Then("has the initials {string}")
    public void hasTheInitials(String string) {
        employee.getInitials();
    }

    @Then("the employee {string} does not exist in the Database")
    public void theEmployeeDoesNotExistInTheDatabase(String string) {
        assertFalse(employee.employeeExists());
    }
}