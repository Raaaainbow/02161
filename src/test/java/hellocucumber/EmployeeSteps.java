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

    @Then("the employee {string} exists in the Database")
    public void theEmployeeExistsInTheDatabase(String initials) {
        employee.checkEmployeeExists(initials);
        assertTrue(employee.employeeExists());
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

    @Given("employee exists in the Database for the given project")
    public void employeeExistsInTheDatabaseForTheGivenProject() {
        
    }

    @Given("there is no project leader in the project")
    public void thereIsNoProjectLeaderInTheProject() {
    }

    @When("the employee creates a task in the project")
    public void theEmployeeCreatesATaskInTheProject() {

    }

    @Then("the task is created")
    public void theTaskIsCreated() {

    }

    @Given("there is a project leader in the project")
    public void thereIsAProjectLeaderInTheProject() {

    }

    @Then("the task is not created and an error message occurs")
    public void theTaskIsNotCreatedAndAnErrorMessageOccurs() {

    }
}