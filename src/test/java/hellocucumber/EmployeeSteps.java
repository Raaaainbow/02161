// mob programming Sophia, Katarina, Caroline

package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.Database;
import dtu.example.Employee;
import dtu.example.Project;
import dtu.example.Task;

public class EmployeeSteps {
    private Employee employee;
    private Task task;
    private Database database;
    private Project project;

    @Given("the database is initialized")
    public void theDatabaseIsInitialized() {
        database = new Database();
    }
    
    @Given("an employee is created with initials {string}")
    public void anEmployeeExistsWithInitials(String initials) {
        database.createEmployee(initials);
        employee = database.getEmployee(initials);
    }

    @Then("the employee {string} exists in the Database")
    public void theEmployeeExistsInTheDatabase(String initials) {
        assertTrue(database.employeeExists(initials));
    }

    @Then("the employee {string} does not exist in the Database")
    public void theEmployeeDoesNotExistInTheDatabase(String initials) {
        assertFalse(database.employeeExists(initials));
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
        database.createProject(title);
        this.project = database.getProject(title);
    }

    @Then("a project with the title {string} is created")
    public void aProjectWithTheTitleIsCreated(String title) {
        assertTrue(database.projectExistsTitle(title));
    }

    @When("the employee creates a project without a title")
    public void theEmployeeCreatesAProjectWithoutATitle() {
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber();
        this.project = database.getProjectByNumber(projectNumber);
    }

    @Then("a project without a title is created with the project number {string}")
    public void aProjectWithoutATitleIsCreatedWithTheProjectNumber(String number) {
        assertTrue(database.projectExistsNumber(number));
    }

    @Then("the project has the project number {string}")
    public void theProjectHasTheProjectNumber(String projectNumber) {
        assertEquals(project.getProjectNumber(), projectNumber);
    }

    @Given("there is no project leader in the project")
    public void thereIsNoProjectLeaderInTheProject() {
        assertFalse(project.projectLeaderInProject());
    }
    
    @When("the employee creates a task {string} using {int} hours starting in week {int} and ending in week {int} in the project")
    public void theEmployeeCreatesAnActivityUsingHoursStartingInWeekAndEndingInWeekInTheProject(String title, int hours, int startWeek, int endWeek) {
        project.createTask(title, hours, startWeek, endWeek, project.getProjectNumber());
        this.task = project.getTask();
    }
    
    @Then("the task {string} is created")
    public void theTaskIsCreated(String title) {
        assertTrue(project.taskExists(title));      
    }

    @Then("the activity {string} has the starting week {int} and ending week {int}")
    public void theActivityHasTheStartingWeekAndEndingWeek(String title, int startWeek, int endweek) {
        assertEquals(task.getStartWeek(), startWeek);
        assertEquals(task.getEndWeek(), endweek);
    } 

    @Given("there is a project leader in the project")
    public void thereIsAProjectLeaderInTheProject() {
        assertTrue(project.projectLeaderInProject());
    }

    @When("the employee tries to create a task {string} using {int} hours starting in week {int} and ending in week {int} in the project")
    public void theEmployeeTriesToCreateAnActivityUsingHoursStartingInWeekAndEndingInWeekInTheProject(String title, int hours, int startWeek, int endWeek) {
        try {
            project.createTask(title, hours, startWeek, endWeek, project.getProjectNumber());
        } catch (IllegalArgumentException e) {
            assertEquals("Start week or end week is not valid", e.getMessage());
        }
    }

    @Then("the task {string} is not created")
    public void theTaskIsNotCreated(String title) {
        assertFalse(project.taskExists(title));

    }
}