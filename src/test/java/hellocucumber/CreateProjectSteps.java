package hellocucumber;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.*;

import dtu.example.Project;
import dtu.example.Task;

public class CreateProjectSteps {
    public Project project;
    private Task task;
    private Project createdProject;
    private String givenProjectName;

    @Given("there is a task")
    public void thereIsATask() {
        assertNotNull(project.taskExists());
    }

    @When("the employee creates a project")
    public void theEmployeeCreatesAProject() {
        createdProject = new Project(task);
    }

    @And("the employee does not provide a project name")
    public void theEmployeeDoesNotProvideAProjectName() {
        assertNull(createdProject.getTitle());
    }

    @Then("the system assigns a project number to the new project")
    public void theSystemAssignsAProjectNumberToTheNewProject() {
        assertNotNull(createdProject.getProjectNumber());
        System.out.println("Assigned project number: " + createdProject.projectNumber);
    }

    @When("the employee creates a project with the name {string}")
    public void theEmployeeCreatesAProjectWithAName() {
        givenProjectName = "ByggeProjekt";
        createdProject = new Project(givenProjectName);
    }

    @Then("the system assigns a project number to the project")
    public void theSystemAssignsAProjectNumberToTheProject() {
        assertNotNull(createdProject.getProjectNumber());
    }

    @Then("the project is saved with the name {string}")
    public void theProjectIsSavedWithTheGivenName() {
        assertEquals(givenProjectName, createdProject.getTitle());
    }
}

