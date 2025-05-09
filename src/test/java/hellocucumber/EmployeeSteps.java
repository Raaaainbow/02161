// mob programming Sophia, Katarina, Caroline

package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.Employee;

public class EmployeeSteps {
    private Employee employee;

    @Given("an employee is created with initials {string}")
    public void anEmployeeExistsWithInitials(String initials) {
        employee = new Employee(initials);
    }

    @Then("the employee exists in the Database")
    public void theEmployeeExistsInTheDatabase() {
        assertTrue(employee.employeeExists());
    }

    @Then("has the initials {string}")
    public void hasTheInitials(String initials) {
        assertEquals(initials, employee.getInitials());
    }

    @Then("the employee {string} does not exist in the Database")
    public void theEmployeeDoesNotExistInTheDatabase(String string) {
        assertFalse(employee.employeeExists());
    }

    @Given("an employee has the initials {string}")
    public void anEmployeeHasTheInitials(String initials) {
        employee = new Employee(initials);
        assertEquals(initials, employee.getInitials());
    }

    @When("the employee change their initials to {string}")
    public void theEmployeeChangeTheirInitialsTo(String newInitials) {
        employee.changeInitials(newInitials);
    }

    @Then("the employee has the initials {string}")
    public void theEmployeeHasTheInitials(String initials) {
        assertEquals(initials, employee.getInitials());
    }
}