// mob programming Sophia, Katarina, Caroline

package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.Employee;
import dtu.example.Task;

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

    @When("the employee creates a project with the title {string}")
    public void theEmployeeCreatesAProjectWithTheTitle(String title) {
        employee.createProjectWithTitle(title);
    }

    @Then("a project with the title {string} is created")
    public void aProjectWithTheTitleIsCreated(String title) {
        assertTrue(employee.projectExistsTitle(title));
    }

    @When("the employee creates a project without a title")
    public void theEmployeeCreatesAProjectWithoutATitle() {
        employee.createProject();
    }

    @Then("a project without a title is created with the project number {string}")
    public void aProjectWithoutATitleIsCreatedWithTheProjectNumber(String number) {
        assertTrue(employee.projectExistsNumber(number));
    }

    @Given("the employee {string} exists in the Database for the given project")
    public void theEmployeeExistsInTheDatabaseForTheGivenProject(String initials) {
        assertTrue(employee.checkEmployeeInProject(initials));
    }

    @Given("there is no project leader in the project")
    public void thereIsNoProjectLeaderInTheProject() {
        assertFalse(employee.projectLeaderInProject());
    }
    
    @When("the employee creates a task {string} in the project")
    public void theEmployeeCreatesATaskInTheProject(String title) {
        employee.createTask(title);
    }
    
    @Then("the task {string} is created")
    public void theTaskIsCreated(String title) {
        assertTrue(employee.taskExists(title));      
    }

    @Given("there is a project leader in the project")
    public void thereIsAProjectLeaderInTheProject() {
        assertTrue(employee.projectLeaderInProject());
    }

    @Then("the task {string} is not created")
    public void theTaskIsNotCreated(String title) {
        assertFalse(employee.taskExists(title));
    }
}