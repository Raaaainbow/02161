// mob programming Sophia, Caroline, Sebastian

package hellocucumber;

import io.cucumber.java.en.*;
import java.time.LocalDate;

import dtu.example.backend.TimeRegistration;

import static org.junit.jupiter.api.Assertions.*;

public class TimeRegistrationSteps {
    private String employeeInitials;
    private TimeRegistration timeRegistration;
    private LocalDate currentDate;

    @Given("today's date is {string}")
    public void todays_date_is(String date) {
        currentDate = LocalDate.parse(date);
    }

    @Given("I am an employee with initials {string}")
    public void i_am_an_employee_with_initials(String initials) {
        employeeInitials = initials;
    }

    @When("I register {double} hours worked on {string}")
    public void i_register_hours_worked_on(double hours, String date) {
        LocalDate workDate = LocalDate.parse(date);
        timeRegistration = new TimeRegistration(hours, employeeInitials, workDate);
    }

    @Given("I have a time registration with initials {string} for {double} hours on {string}")
    public void i_have_a_time_registration_with_initials_for_hours_on(String initials, double hours, String date) {
        LocalDate workDate = LocalDate.parse(date);
        timeRegistration = new TimeRegistration(hours, initials, workDate);
    }

    @Given("there are no shift times")
    public void there_are_no_shift_times() {
        // No action needed - this is the default state
    }

    @Then("my time registration should show {double} hours")
    public void my_time_registration_should_show_hours(double expectedHours) {
        assertEquals(expectedHours, timeRegistration.getHours(), 0.01);
    }

    @Then("the date should be {string}")
    public void the_date_should_be(String expectedDate) {
        assertEquals(LocalDate.parse(expectedDate), timeRegistration.getDate());
    }

    @Then("my initials should be {string}")
    public void my_initials_should_be(String expectedInitials) {
        assertTrue(timeRegistration.toString().contains(expectedInitials));
    }

    @Then("the display should show {string}")
    public void the_display_should_show(String expectedDisplay) {
        assertEquals(expectedDisplay, timeRegistration.toString());
    }
}
