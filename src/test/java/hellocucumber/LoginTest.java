package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

    private boolean loggedIn = false;
    private String correctInitials;
    private String enteredInitials;

    @Given("that the employee is not logged in")
    public void thatTheEmployeeIsNotLoggedIn() {
        loggedIn = false; 
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
        }
    }

    @Then("the employee is logged in")
    public void theEmployeeIsLoggedIn() {
        assertEquals(true, loggedIn);
    }

    @Then("the employee is redirected to the application")
    public void theEmployeeIsRedirectedToTheApplication() {
        if (loggedIn) {
            System.out.println("Redirecting to application...");
        } else {
            System.out.println("Stay on login page.");
        }
    }


    
}
