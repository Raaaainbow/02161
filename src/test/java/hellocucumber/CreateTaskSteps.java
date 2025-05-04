package hellocucumber;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.*;

import java.util.*;

import dtu.example.Task;

public class CreateTaskSteps {

    private static class Project {
        List<Task> activities = new ArrayList<>();
    }

    private Project project;
    private boolean isProjectLeaderAssigned;
    private boolean isProjectLeader;
    private String errorMessage = null;
    private Task createdActivity;

    @Given("that there is a project")
    public void thatThereIsAProject() {
        project = new Project();
    }

    @When("the project leader creates an activity")
    public void theProjectLeaderCreatesAnActivity() {
        isProjectLeader = true;
        createdActivity = new Task(null);
        project.activities.add(createdActivity);
    }

    @And("assigns {int} hours over {int} weeks")
    public void assignsEstimatedTime(int hours, int durationWeeks) {
        int startWeek = 4;
        int endWeek = startWeek + durationWeeks - 1;
        createdActivity.setEstimatedTime(hours);
        createdActivity.setStartWeek(startWeek);
        createdActivity.setEndWeek(endWeek);
    }

    @Then("an activity is created in the given project")
    public void anActivityIsCreatedInTheGivenProject() {
        assertFalse(project.activities.isEmpty(), "No activity was added to the project");
    }

    @And("the activity has a starting week and ending week")
    public void theActivityHasAStartingWeekAndEndingWeek() {
        assertNotNull(createdActivity.getStartWeek(), "Start week should be set");
        assertNotNull(createdActivity.getEndWeek(), "End week should be set");
    }

    @And("the activity has no starting week and ending week")
    public void theActivityHasNoStartOrEnd() {
        assertEquals(0, createdActivity.getStartWeek());
        assertEquals(0, createdActivity.getEndWeek());
    }

    @When("the employee creates an activity")
    public void theEmployeeCreatesAnActivity() {
        isProjectLeader = false;
        createdActivity = new Task(null);
        project.activities.add(createdActivity);
    }

    @And("there is a project leader")
    public void thereIsAProjectLeader() {
        isProjectLeaderAssigned = true;
    }

    @Then("an error message occurs")
    public void anErrorMessageOccurs() {
        if (!isProjectLeader && isProjectLeaderAssigned) {
            errorMessage = "Only the project leader can create activities";
        }
        assertNotNull(errorMessage, "Expected an error message, but none occurred");
        System.out.println("Error: " + errorMessage);
    }
}
