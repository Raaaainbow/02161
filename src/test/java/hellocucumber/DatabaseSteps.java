package hellocucumber;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import dtu.example.Database;
import dtu.example.Project;

public class DatabaseSteps {

    private Database db;

    @Given("the database is initialized")
    public void theDatabaseIsInitialized() {
        db = new Database();
    }

    @When("I create a project with ID {string}, start week {int}, and end week {int}")
    public void iCreateAProjectWithIDStartWeekAndEndWeek(String id, int startWeek, int endWeek) {
        db.createProject(id);
        Project proj = db.getProject(id);
        proj.setStartWeek(startWeek);
        proj.setEndWeek(endWeek);
    }

    @Then("the project {string} should be stored in the database")
    public void theProjectShouldBeStoredInTheDatabase(String id) {
        assertNotNull(db.getProject(id));
    }

    @Then("its start week should be {int}")
    public void itsStartWeekShouldBe(int expectedStartWeek) {
        Project project = db.getProject("P123"); // hardcoded for now
        assertEquals(expectedStartWeek, project.getStartWeek());
    }

    @Then("its end week should be {int}")
    public void itsEndWeekShouldBe(int expectedEndWeek) {
        Project project = db.getProject("P123");
        assertEquals(expectedEndWeek, project.getEndWeek());
    }

    @Before
    public void setup() {
        db = new Database();
    }

    @Given("a project with name {string} exists in the database")
    public void aProjectWithNameExistsInTheDatabase(String string) {
        db.createProject(string);
        Project proj = db.getProject(string);
        assertTrue(db.projectExistsTitle(proj.getTitle())); // <-- proj is null here
    }

    @When("I update the project {string} to end in week {int}")
    public void iUpdateTheProjectToEndInWeek(String string, Integer int1) {
        Project proj = db.getProject(string);
        proj.setEndWeek(int1);
    }

    @Then("the project {string} should have end week {int}")
    public void theProjectShouldHaveEndWeek(String string, Integer int1) {
        Project proj = db.getProject(string);
        assertEquals(int1, proj.getEndWeek());
    }

    @When("I create a new user with initials {string}")
    public void iCreateANewUserWithInitials(String string) {
        db.createEmployee(string);
    }

    @Then("the user {string} should be stored in the database")
    public void theUserShouldBeStoredInTheDatabase(String string) {
        assertTrue(db.employeeExists(string));
    }

    @When("I create a new project without any parameters")
    public void iCreateaANewProjectWithoutAnyParameters() {
        db.createProject();
    }

    @Then("the project is created with a generated Id")
    public void theProjectIsCreatedWithAGeneratedId() {
        List<Project> projects = db.getProjects();
        assertNotNull(projects.getLast().getId());
        
    }

    @When("I request a list of all employees")
    public void iRequestAListOfAllEmployees() {
        db.getEmployees();
    }

    @Then("I get a list of all employees")
    public void iGetAListOfAllEmployees() {
        assertNotNull(db.getEmployees());
    }
}
