package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.Employee;
import dtu.example.LogIn;

public class LoginSteps {
    private LogIn logIn = new LogIn();
    private Employee employee;

    @Given("that the employee {string} exists")
    public void thatTheEmployeeExists(String initials) {
        employee = new Employee(initials);
        employee.checkEmployeeExists(initials);
        assertTrue(employee.employeeExists());
    }

    @Given("that the employee is not logged in")
    public void thatTheEmployeeIsNotLoggedIn() {
        assertFalse(logIn.isLoggedIn());
    }

    @When("the employee enters {string}")
    public void theEmployeeEnters(String initials) {
        assertEquals(initials, logIn.getCorrectInitials());
    }

    @Then("the employee {string} is logged in")
    public void theEmployeeIsLoggedIn(String initials) {
        logIn.loggingIn(initials);
        assertTrue(logIn.isLoggedIn());
    }

    @Then("the employee is redirected to the application")
    public void theEmployeeIsRedirectedToTheApplication() {
        assertTrue(logIn.isLoggedIn());
        System.out.println("Redirecting to application...");
    }

    @Then("the employee {string} is not logged in")
    public void theEmployeeIsNotLoggedIn(String initials) {
        logIn.loggingIn(initials);
        assertFalse(logIn.isLoggedIn());
    }
}
