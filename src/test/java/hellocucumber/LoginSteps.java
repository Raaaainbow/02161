package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import dtu.example.LogIn;

public class LoginSteps {
    private String correctInitials = "abcd";
    private String enteredInitials;
    private boolean loggedIn = false;
    private String errorMessage = null;

    @Given("that the employee is not logged in")
    public void thatTheEmployeeIsNotLoggedIn() {
        assertEquals(false, loggedIn);
    }

    @Given("the right initials is {string}")
    public void theRightInitialsIs(String initials) {
        this.correctInitials = initials;
    }

    @When("the employee enters {string}")
    public void theEmployeeEnters(String initials) {
        this.enteredInitials = initials;
        if (enteredInitials.equals(correctInitials)) {
            loggedIn = true;
        } else {
            loggedIn = false;
            errorMessage = "Incorrect initials";
        }
    }

    @Then("the employee is logged in")
    public void theEmployeeIsLoggedIn() {
        assertTrue(loggedIn, "Employee should be logged in");
    }

    @Then("the employee is redirected to the application")
    public void theEmployeeIsRedirectedToTheApplication() {
        assertTrue(loggedIn, "Employee must be logged in to be redirected");
        System.out.println("Redirecting to application...");
    }

    @Then("the employee is not logged in")
    public void theEmployeeIsNotLoggedIn() {
        assertFalse(loggedIn, "Employee should not be logged in");
    }

    @Then("the employee is shown an error message")
    public void theEmployeeIsShownAnErrorMessage() {
        assertNotNull(errorMessage, "An error message should be shown");
        assertEquals("Incorrect initials", errorMessage);
    }
}
