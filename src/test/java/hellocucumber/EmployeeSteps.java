
package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.backend.Database;
import dtu.example.backend.Employee;
import dtu.example.backend.Project;
import dtu.example.backend.Task;

public class EmployeeSteps {
    private Employee employee;
    private Task task;
    private Database database;
    private Project project;
    private String title;
    private LocalDate vacationStartDate;
    private LocalDate vacationEndDate;
    private LocalDate sickLeaveStartDate;
    private LocalDate sickLeaveEndDate;
    private LocalDate courseStartDate;
    private LocalDate courseEndDate;
    private Task course;

    // Katarina
    @Given("the database is initialized")
    public void theDatabaseIsInitialized() {
        database = new Database();
    }
    // Sophia
    @Given("an employee is created with initials {string}")
    public void anEmployeeExistsWithInitials(String initials) {
        database.createEmployee(initials);
        employee = database.getEmployee(initials);
    }
    // Caroline
    @Then("the employee {string} exists in the Database")
    public void theEmployeeExistsInTheDatabase(String initials) {
        assertTrue(database.employeeExists(initials));
    }
    // Katarina
    @Then("the employee {string} does not exist in the Database")
    public void theEmployeeDoesNotExistInTheDatabase(String initials) {
        assertFalse(database.employeeExists(initials));
    }
    // Sophia
    @Given("an employee has the initials {string}")
    public void anEmployeeHasTheInitials(String initials) {
        employee = new Employee(initials);
        assertEquals(initials, employee.getInitials());
    }
    // Caroline
    @When("the employee change their initials to {string}")
    public void theEmployeeChangeTheirInitialsTo(String newInitials) {
        employee.changeInitials(newInitials);
    }
    // Katarina
    @Then("the employee has the initials {string}")
    public void theEmployeeHasTheInitials(String initials) {
        assertEquals(initials, employee.getInitials());
    }
    // Sophia
    @When("the employee creates a project with the title {string}")
    public void theEmployeeCreatesAProjectWithTheTitle(String title) {
        database.createProject(title);
        this.project = database.getProject(title);
    }
    // Caroline
    @Then("a project with the title {string} is created")
    public void aProjectWithTheTitleIsCreated(String title) {
        assertTrue(database.projectExistsTitle(title));
    }
    // Katarina
    @When("the employee creates a project without a title")
    public void theEmployeeCreatesAProjectWithoutATitle() {
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber();
        this.project = database.getProjectByNumber(projectNumber);
    }
    // Sophia
    @Then("a project without a title is created with the project number {string}")
    public void aProjectWithoutATitleIsCreatedWithTheProjectNumber(String number) {
        assertTrue(database.projectExistsNumber(number));
    }
    // Caroline
    @Then("the project has the project number {string}")
    public void theProjectHasTheProjectNumber(String projectNumber) {
        assertEquals(project.getProjectNumber(), projectNumber);
    }
    // Katarina
    @Given("there is no project leader in the project")
    public void thereIsNoProjectLeaderInTheProject() {
        assertFalse(project.projectLeaderInProject());
    }
    // Sophia
    @When("the employee creates a task {string} using {double} hours starting in week {int} and ending in week {int} in the project")
    public void theEmployeeCreatesAnActivityUsingHoursStartingInWeekAndEndingInWeekInTheProject(String title, double hours, int startWeek, int endWeek) {
        project.createTask(title, hours, startWeek, endWeek, project.getProjectNumber());
        this.task = project.getTaskByTitle(title);
    }
    // Caroline
    @Then("the task {string} is created in the project")
    public void theTaskIsCreatedInTheProject(String title) {
        assertTrue(project.taskExists(title));      
    }
    // Katarina
    @Then("the task {string} is created")
    public void theTaskIsCreated(String title) {
        assertTrue(employee.taskExists(title));      
    }
    // Sophia
    @Then("the task {string} has the starting week {int} and ending week {int}")
    public void theTaskHasTheStartingWeekAndEndingWeek(String title, int startWeek, int endweek) {
        assertEquals(task.getStartWeek(), startWeek);
        assertEquals(task.getEndWeek(), endweek);
    } 
    // Caroline
    @Given("there is a project leader in the project")
    public void thereIsAProjectLeaderInTheProject() {
        project.makeProjectLeader("efgh");
        assertTrue(project.projectLeaderInProject());
    }
    // Katarina
    @When("the employee tries to create a task {string} using {double} hours starting in week {int} and ending in week {int} in the project")
    public void theEmployeeTriesToCreateAnActivityUsingHoursStartingInWeekAndEndingInWeekInTheProject(String title, double hours, int startWeek, int endWeek) {
        if (!project.projectLeaderInProject() || project.getProjectLead().equals(employee.getInitials())) {
            try {
                project.createTask(title, hours, startWeek, endWeek, project.getProjectNumber());
            } catch (IllegalArgumentException e) {
                assertTrue(
                    e.getMessage().equals("Start week and end week is not valid") ||
                    e.getMessage().equals("Start week is not valid") ||
                    e.getMessage().equals("End week is not valid")
                );
            }
        }
        
        assertNull(project.getTaskByTitle(title));
    }
    // Sophia
    @Then("the task {string} is not created in the project")
    public void theTaskIsNotCreatedInTheProject(String title) {
        assertFalse(project.taskExists(title));
    }
    // Caroline
    @Then("the task {string} is not created")
    public void theTaskIsNotCreated(String title) {
        assertFalse(employee.taskExists(title));      
    }
    // Katarina
    @When("the employee creates a vacation task starting {string} and ending {string}")
    public void theEmployeeCreatesAVacationTaskStartingAndEnding(String startDate, String endDate) {
        this.vacationStartDate = LocalDate.parse(startDate);
        this.vacationEndDate = LocalDate.parse(endDate);
        employee.createVacation(vacationStartDate, vacationEndDate);
        this.title = employee.getTitle();
    }
    // Sophia
    @Then("the vacation task is created")
    public void theVacationTaskIsCreated() {
        assertNotNull(employee.getVacation(title));
    }
    // Caroline
    @When("the employee creates a sick leave task starting {string} and ending {string}")
    public void theEmployeeCreatesASickLeaveTaskStartingAndEnding(String startDate, String endDate) {
        this.sickLeaveStartDate = LocalDate.parse(startDate);
        this.sickLeaveEndDate = LocalDate.parse(endDate);
        employee.createSickLeave(sickLeaveStartDate, sickLeaveEndDate);
        this.title = employee.getTitle();
    }
    // Katarina
    @Then("the sick leave task is created")
    public void theSickLeaveTaskIsCreated() {
        assertNotNull(employee.getSickLeave(title));
    }
    // Sophia
    @When("the employee creates a course task starting {string} and ending {string}")
    public void theEmployeeCreatesACourseTaskStartingAndEnding(String startDate, String endDate) {
        this.courseStartDate = LocalDate.parse(startDate);
        this.courseEndDate = LocalDate.parse(endDate);
        employee.createCourse(courseStartDate, courseEndDate);
        this.title = employee.getTitle();
        this.course = employee.getCourse(title);
    }
    // Caroline
    @Then("the course task is created")
    public void theCourseTaskIsCreated() {
        assertNotNull(employee.getCourse(title));
    }
    // Katarina
    @When("the employee creates their vacation list")
    public void theEmployeeCreatesTheirVacationList() {
        employee.getVacationList();
    }
    // Sophia
    @Then("the vacation list is shown")
    public void theVacationListIsShown() {
        assertNotNull(employee.getVacationList());
    }
    // Caroline
    @When("the employee creates their sick leave list")
    public void theEmployeeCreatesTheirSickLeaveList() {
        employee.getSickLeaveList();
    }
    // Katarina
    @Then("the sick leave list is shown")
    public void theSickLeaveListIsShown() {
        assertNotNull(employee.getSickLeaveList());
    }
    // Sophia
    @When("the employee creates their course list")
    public void theEmployeeCreatesTheirCourseList() {
        employee.getCourseList();
    }
    // Caroline
    @Then("the course list is shown")
    public void theCourseListIsShown() {
        assertNotNull(employee.getCourseList());
    }
    // Katarina
    @When("the employee creates a task {string} using {double} hours starting in week {int} and ending in week {int}")
    public void theEmployeeCreatesAnActivityUsingHoursStartingInWeekAndEndingInWeek(String title, double hours, int startWeek, int endWeek) {
        employee.createTask(title, hours, startWeek, endWeek);
        this.task = employee.getTaskByTitle(title);
    }
    // Sophia
    @When("the employee tries to create a task {string} using {double} hours starting in week {int} and ending in week {int}")
    public void theEmployeeTriesToCreateATaskUsingHoursStartingInWeekAndEndingInWeek(String title, double hours, int startWeek, int endWeek) {
        try {
            employee.createTask(title, hours, startWeek, endWeek);
        } catch (IllegalArgumentException e) {
            assertTrue(
                e.getMessage().equals("Start week and end week is not valid") ||
                e.getMessage().equals("Start week is not valid") ||
                e.getMessage().equals("End week is not valid")
            );
        }
    }
    // Caroline
    @When("the task is assigned to employee {string}")
    public void theTaskIsAssignedToEmployee(String initials) {
        this.employee = database.getEmployee(initials);
        task.setAssignedEmployee(employee); 
    }
    // Katarina
    @Then("the task string representation should be:")
    public void theTaskStringRepresentationShouldBe(String expected) {
        assertEquals(expected.trim(), task.toString().trim());
    }
    // Sophia
    @Then("the course task string representation should be:")
    public void theCourseTaskStringRepresentationShouldBe(String expected) {
        assertEquals(expected.trim(), course.toString2().trim());
    }
    // Caroline
    @When("the employee creates their project list")
    public void theEmployeeCreatesTheirProjectList() {
        database.getProjects(); 
    }
    // Katarina
    @Then("the project list is shown")
    public void theProjectListIsShown() {
        assertNotNull(database.getProjects());
    }
    // Sophia
    @Then("the project list string representation should be:")
    public void theProjectListStringRepresentationShouldBe(String expected) {
        assertEquals(expected.trim(), project.toString().trim());
    }
    // Caroline
    @When("the employee creates their task list")
    public void theEmployeeCreatesTheirTaskList() {
        project.getTasks();
    }
    // Katarina
    @Then("the task list is shown")
    public void theTaskListIsShown() {
        assertNotNull(project.getTasks());
    }
    // Sophia
    @Then("the task list string representation should be:")
    public void theTaskListStringRepresentationShouldBe(String expected) {
        assertEquals(expected.trim(), task.toString().trim());
    }
    // Caroline
    @Then("the assigned task list is shown")
    public void theAssignedTaskListIsShown() {
        List<Task> assignedTask = employee.getAssignedTasks();
        assertNotNull(assignedTask);
    }
    
}