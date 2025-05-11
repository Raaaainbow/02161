package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.Database;
import dtu.example.Employee;
import dtu.example.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectLeaderSteps {
    Database database = new Database();

    @Given("the database is initialised")
    public void theDatabaseIsInitialised() {
        assertTrue(this.database != null);
    }

    @Given("the following employees exist: {string} {string} {string}")
    public void theFollowingEmployeesExist(String string, String string2, String string3) {
        database.createEmployee(string);
        database.createEmployee(string2);
        database.createEmployee(string3);
    }

    @Given("the project {string} exists")
    public void theProjectExists(String string) {
        database.createProject(string);;
        assertTrue(database.projectExistsNumber(string));
    }

    @When("I promote employee with initials {string} to project leader on {string}")
    public void iPromoteEmployeeWithInitialsToProjectLeaderOn(String initials, String projectNumber) {
        Project project = database.getProjectByNumber(projectNumber);
        project.setProjectLead(initials);
    }

    @Then("the employee with initials {string} should be a project leader on {string}")
    public void theEmployeeWithInitialsShouldBeAProjectLeaderOn(String initials, String projectNumber) {
        Project project = database.getProjectByNumber(projectNumber);
        assertEquals(initials, project.getProjectLead());
    }

    @Given("the project {string} exist")
    public void theProjectExist(String projectNumber) {
        assertTrue(database.getProjectByNumber(projectNumber) != null);
    }

    @Given("the project {string} does not have a project leader")
    public void theProjectDoesNotHaveAProjectLeader(String projectNumber) {
        Project project = database.getProjectByNumber(projectNumber);
        assertTrue(!(project.projectLeaderInProject()));
    }

    @When("{string} assigns them self as project leader on project {string}")
    public void assignsThemSelfAsProjectLeader(String initials, String projectNumber) {
        Project project = database.getProjectByNumber(projectNumber);
        project.setProjectLead(initials);
    }

    @Then("a project leader with initials {string} should exist on project {string}")
    public void aProjectLeaderWithInitialsShouldExist(String initials, String projectNumber) {
        Project project = database.getProjectByNumber(projectNumber);
        assertEquals(initials, project.getProjectLead());
    }
}
