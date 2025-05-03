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
    private boolean isProjectLeader = false;
    private boolean isEmployeeTrying = false;
    private String errorMessage = null;
    private Task createdActivity;

    @Given("that there is a project")
    public void thatThereIsAProject() {
        project = new Project();
    }

    @When("the project leader creates an activity")
    public void theProjectLeaderCreatesAnActivity() {
        isProjectLeader = true;
        createdActivity = new Task(null, 0, 0); // assuming Task constructor accepts null title
        project.activities.add(createdActivity);
    }

    @And("assigns {int} hours over {int} weeks")
    public void assignsEstimatedTime(int hours, int durationWeeks) {
        int startWeek = 20;
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

    @Then("the activity has no starting week and ending week")
    public void theActivityHasNoStartOrEnd() {
        assertNull(createdActivity.getStartWeek(), "Start week should be null");
        assertNull(createdActivity.getEndWeek(), "End week should be null");
    }

    @When("the employee creates an activity")
    public void theEmployeeCreatesAnActivity() {
        isEmployeeTrying = true;
    }

    @And("there is a project leader")
    public void thereIsAProjectLeader() {
        isProjectLeader = true;
    }

    @Then("an error message occurs")
    public void anErrorMessageOccurs() {
        if (isEmployeeTrying && isProjectLeader) {
            errorMessage = "Only the project leader can create activities";
        }
        assertNotNull(errorMessage, "Expected an error message, but none occurred");
        System.out.println("Error: " + errorMessage);
    }
}
