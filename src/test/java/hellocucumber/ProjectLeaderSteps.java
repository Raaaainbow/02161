// mob programming Caroline, Sophia, Katarina

package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dtu.example.Database;
import dtu.example.Employee;
import dtu.example.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectLeaderSteps {
    Database database = new Database();
    private Project project;

    @Given("the database is initialised")
    public void theDatabaseIsInitialised() {
        assertTrue(this.database != null);
    }

    @Given("the project {string} exists")
    public void theProjectExists(String projectNumber) {
        this.project = database.getProjectByNumber(projectNumber);
        assertTrue(database.projectExistsNumber(projectNumber));
    }

    @When("an employee promotes employee {string} to project leader in the project")
    public void anEmployeePromotesEmployeeToProjectLeaderInProject(String initials) {
        project.makeProjectLeader(initials);
    }

    @Then("the employee {string} is the project leader in the project")
    public void theEmployeeIsTheProjectLeaderInProject(String initials) {
        assertEquals(initials, project.getProjectLead());
    }

    @Given("{string} is project leader in the project")
    public void isProjectLeaderInTheProject(String initials) {
        project.makeProjectLeader(initials);
        assertEquals(initials, project.getProjectLead());
    }

    @When("an employee tries to promote employee {string} to project leader in the project")
    public void anEmployeeTriesToPromoteEmployeeToProjectLeaderInProject(String initials) {
        try {
            project.makeProjectLeader(initials);
        } catch (IllegalArgumentException e) {
            assertEquals(project.getProjectLead() + "is the project leader of this project", e.getMessage());
        }
    }

    @Then("the employee {string} is not promoted to project leader")
    public void theEmployeeIsNotPromotedToProjectLeader(String initials) {
        assertNotEquals(initials, project.getProjectLead());
    }

//     @When("I promote employee with initials {string} to project leader on {string}")
//     public void iPromoteEmployeeWithInitialsToProjectLeaderOn(String initials, String projectNumber) {
//         Project project = database.getProjectByNumber(projectNumber);
//         project.setProjectLead(initials);
//     }

//     @Then("the employee with initials {string} should be a project leader on {string}")
//     public void theEmployeeWithInitialsShouldBeAProjectLeaderOn(String initials, String projectNumber) {
//         Project project = database.getProjectByNumber(projectNumber);
//         assertEquals(initials, project.getProjectLead());
//     }

//     @Given("the project {string} exist")
//     public void theProjectExist(String projectNumber) {
//         assertTrue(database.getProjectByNumber(projectNumber) != null);
//     }

//     @Given("the project {string} does not have a project leader")
//     public void theProjectDoesNotHaveAProjectLeader(String projectNumber) {
//         Project project = database.getProjectByNumber(projectNumber);
//         assertTrue(!(project.projectLeaderInProject()));
//     }

//     @When("{string} assigns them self as project leader on project {string}")
//     public void assignsThemSelfAsProjectLeader(String initials, String projectNumber) {
//         Project project = database.getProjectByNumber(projectNumber);
//         project.setProjectLead(initials);
//     }

//     @Then("a project leader with initials {string} should exist on project {string}")
//     public void aProjectLeaderWithInitialsShouldExist(String initials, String projectNumber) {
//         Project project = database.getProjectByNumber(projectNumber);
//         assertEquals(initials, project.getProjectLead());
//     }

}
