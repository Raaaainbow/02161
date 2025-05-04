package hellocucumber;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.*;
import java.util.UUID;

import dtu.example.Project;

public class CreateProjectSteps {

    private boolean taskExists;
    private Project createdProject;
    private String givenProjectName;

    @Given("there is a task")
    public void thereIsATask() {
        taskExists = true;
    }

    @When("the employee creates a project")
    public void theEmployeeCreatesAProject() {
        assertTrue(taskExists);
        createdProject = new Project(null);
    }

    @And("the employee does not provide a project name")
    public void theEmployeeDoesNotProvideAProjectName() {
        assertNull(createdProject.getTitle());
    }

    @Then("the system assigns a project number to the new project")
    public void theSystemAssignsAProjectNumberToTheNewProject() {
        assertNotNull(createdProject.projectNumber);
        System.out.println("Assigned project number: " + createdProject.projectNumber);
    }

    @When("the employee creates a project with a name")
    public void theEmployeeCreatesAProjectWithAName() {
        givenProjectName = "Green Energy";
        createdProject = new Project(givenProjectName);
    }

    @Then("the system assigns a project number to the project")
    public void theSystemAssignsAProjectNumberToTheProject() {
        assertNotNull(createdProject.projectNumber);
    }

    @And("the project is saved with the given name")
    public void theProjectIsSavedWithTheGivenName() {
        assertEquals(givenProjectName, createdProject.getTitle());
    }
}

