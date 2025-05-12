
package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.backend.Database;
import dtu.example.backend.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectLeaderSteps {
    Database database = new Database();
    private Project project;
    // Sophia
    @Given("the database is initialised")
    public void theDatabaseIsInitialised() {
        assertTrue(this.database != null);
    }
    // Caroline
    @Given("the project {string} exists")
    public void theProjectExists(String projectNumber) {
        this.project = database.getProjectByNumber(projectNumber);
        assertTrue(database.projectExistsNumber(projectNumber));
    }
    // Katarina
    @When("an employee promotes employee {string} to project leader in the project")
    public void anEmployeePromotesEmployeeToProjectLeaderInProject(String initials) {
        project.makeProjectLeader(initials);
    }
    // Sophia
    @Then("the employee {string} is the project leader in the project")
    public void theEmployeeIsTheProjectLeaderInProject(String initials) {
        assertEquals(initials, project.getProjectLead());
    }
    // Caroline
    @Given("{string} is project leader in the project")
    public void isProjectLeaderInTheProject(String initials) {
        project.makeProjectLeader(initials);
        assertEquals(initials, project.getProjectLead());
    }
    // Katarina
    @When("an employee tries to promote employee {string} to project leader in the project")
    public void anEmployeeTriesToPromoteEmployeeToProjectLeaderInProject(String initials) {
        try {
            project.makeProjectLeader(initials);
        } catch (IllegalArgumentException e) {
            assertEquals(project.getProjectLead() + "is the project leader of this project", e.getMessage());
        }
    }
    // Sophia
    @Then("the employee {string} is not promoted to project leader")
    public void theEmployeeIsNotPromotedToProjectLeader(String initials) {
        assertNotEquals(initials, project.getProjectLead());
    }
    // Caroline
    @Given("employee with initials {string} is a project leader in the project {string}")
    public void employeeWithInitialsIsAProjectLeaderInTheProject(String initials, String projectNumber) {
        this.project = database.getProjectByNumber(projectNumber);
        project.makeProjectLeader(initials);
        assertTrue(project.projectLeaderInProject());
        assertEquals(initials, project.getProjectLead());
    }
    // Katarina
    @When("an employee replaces project leader {string} with employee {string} in the project")
    public void an_employee_replaces_project_leader_with_employee_in_the_project(String initials, String initials2) {
        project.setProjectLead(initials2);
        assertEquals(initials2, project.getProjectLead());
    }
    // Sophia
    @Then("employee with initials {string} should no longer be a project leader in project {string}")
    public void employeeWithInitialsShouldNoLongerBeAProjectLeaderInProject(String initials, String projectNumber) {
        assertNotEquals(initials, project.getProjectLead());
    }

}
