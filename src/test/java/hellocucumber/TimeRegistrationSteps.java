// mob programming Sophia, Caroline, Sebastian

package hellocucumber;

import io.cucumber.java.en.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import dtu.example.TimeRegistration;

import static org.junit.jupiter.api.Assertions.*;

public class TimeRegistrationSteps {
    private TimeRegistration timeRegistration;

    // Scenario: Create a new time registration
    @Given("there exists a time registration on {string} and shift ends {string}")
    public void there_exists_a_time_registration_on_and_shift_ends(String shiftStart, String shiftEnd) {
        LocalDateTime start = LocalDateTime.parse(shiftStart);
        LocalDateTime end = LocalDateTime.parse(shiftEnd);
        LocalDate date = start.toLocalDate();
        timeRegistration = new TimeRegistration(start, end, date);
    }

    @Then("the shift start is {string}")
    public void the_shift_start_is(String expectedStart) {
        assertEquals(LocalDateTime.parse(expectedStart), timeRegistration.getShiftStart());
    }

    @Then("the shift end is {string}")
    public void the_shift_end_is(String expectedEnd) {
        assertEquals(LocalDateTime.parse(expectedEnd), timeRegistration.getShiftEnd());
    }

    @Then("the date should be {string}")
    public void the_date_should_be(String expectedDate) {
        assertEquals(LocalDate.parse(expectedDate), timeRegistration.getDate());
    }

    // Scenario: Update shift start time
    @Given("there exists a time registration with shift start {string}")
    public void there_exists_a_time_registration_with_shift_start(String shiftStart) {
        LocalDateTime start = LocalDateTime.parse(shiftStart);
        LocalDate date = start.toLocalDate();
        timeRegistration = new TimeRegistration(start, null, date);
    }

    @When("the shift start is updated to {string}")
    public void the_shift_start_is_updated_to(String newShiftStart) {
        timeRegistration.setShiftStart(LocalDateTime.parse(newShiftStart));
    }

    @Then("the shift start should be {string}")
    public void the_shift_start_should_be(String expectedStart) {
        assertEquals(LocalDateTime.parse(expectedStart), timeRegistration.getShiftStart());
    }

    // Scenario: Update shift end time
    @Given("there exists a time registration with shift end {string}")
    public void there_exists_a_time_registration_with_shift_end(String shiftEnd) {
        LocalDateTime end = LocalDateTime.parse(shiftEnd);
        LocalDate date = end.toLocalDate();
        timeRegistration = new TimeRegistration(null, end, date);
    }

    @When("the shift end is changed to {string}")
    public void the_shift_end_is_changed_to(String newShiftEnd) {
        timeRegistration.setShiftEnd(LocalDateTime.parse(newShiftEnd));
    }

    @Then("the shift end is updated to {string}")
    public void the_shift_end_is_updated_to_(String expectedEnd) {
        assertEquals(LocalDateTime.parse(expectedEnd), timeRegistration.getShiftEnd());
    }

    // Scenario: Mark time registration as deleted
    @Given("there exists a time registration with shift start {string} and shift end {string}")
    public void there_exists_a_time_registration_with_shift_start_and_shift_end(String shiftStart, String shiftEnd) {
        LocalDateTime start = LocalDateTime.parse(shiftStart);
        LocalDateTime end = LocalDateTime.parse(shiftEnd);
        LocalDate date = start.toLocalDate();
        timeRegistration = new TimeRegistration(start, end, date);
    }

    @When("the time registration is deleted")
    public void the_time_registration_is_deleted() {
        timeRegistration.deleteTimeReg();
    }

    @Then("the time registration should be marked as deleted")
    public void the_time_registration_should_be_marked_as_deleted() {
        assertTrue(timeRegistration.isDeleted());
    }

   
}
