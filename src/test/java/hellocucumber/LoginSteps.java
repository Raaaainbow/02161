package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.Database;
import dtu.example.Employee;
import dtu.example.LogIn;

public class LoginSteps {
    private LogIn logIn = new LogIn();
    private Employee employee;
    private Database database;
    private String wrongInitials = "";
    private String initials;

    @Given("that the employee {string} exists")
    public void thatTheEmployeeExists(String initials) {
        this.initials = initials;
        database = new Database();
        employee = new Employee(initials);
        assertTrue(database.employeeExists(initials));
    }

    @Given("that the employee is not logged in")
    public void thatTheEmployeeIsNotLoggedIn() {
        assertFalse(logIn.isLoggedIn());
    }

    @When("the employee {string} enters {string}")
    public void theEmployeeEnters(String correctInitials, String enteredInitials) {
        Employee employee = new Employee(correctInitials);
        logIn.loggingIn(employee, enteredInitials);
    }

    @Then("the employee is logged in")
    public void theEmployeeIsLoggedIn() {
        assertTrue(logIn.isLoggedIn());
    }

    @Then("the employee is redirected to the application")
    public void theEmployeeIsRedirectedToTheApplication() {
        assertTrue(logIn.isLoggedIn());
        System.out.println("Redirecting to application...");
    }

    @Then("the employee is not logged in")
    public void theEmployeeIsNotLoggedIn() {
        assertFalse(logIn.isLoggedIn());
    }

    @Given("that the employee {string} is logged in")
    public void thatTheEmployeeIsLoggedIn(String initials) {
        Employee employee = new Employee(initials);
        logIn.loggingIn(employee, initials);
        assertTrue(logIn.isLoggedIn());
    }

    @Then("the employee is already logged in")
    public void theEmployeeIsAlreadyLoggedIn() {
        assertTrue(logIn.isLoggedIn());
    }

   
}
