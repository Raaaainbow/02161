package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.example.backend.Database;
import dtu.example.backend.Employee;
import dtu.example.backend.LogIn;

public class LoginSteps {
    private LogIn logIn = new LogIn();
    private Employee employee;
    private Database database;
    // Caroline
    @Given("that the database is initialized")
    public void thatTheDatabaseIsInitialized() {
        database = new Database();
    }
    // Katarina
    @Given("that the employee {string} exists")
    public void thatTheEmployeeExists(String initials) {
        database.createEmployee(initials);
        assertTrue(database.employeeExists(initials));
    }
    // Sophia
    @Given("that the employee is not logged in")
    public void thatTheEmployeeIsNotLoggedIn() {
        assertFalse(logIn.isLoggedIn());
    }
    // Caroline
    @When("the employee {string} enters {string}")
    public void theEmployeeEnters(String correctInitials, String enteredInitials) {
        this.employee = database.getEmployee(correctInitials);
        logIn.loggingIn(employee, enteredInitials);
    }
    // Katarina
    @Then("the employee is logged in")
    public void theEmployeeIsLoggedIn() {
        assertTrue(logIn.isLoggedIn());
    }
    // Sophia
    @Then("the employee is redirected to the application")
    public void theEmployeeIsRedirectedToTheApplication() {
        assertTrue(logIn.isLoggedIn());
        System.out.println("Redirecting to application...");
    }
    // Caroline
    @Then("the employee is not logged in")
    public void theEmployeeIsNotLoggedIn() {
        assertFalse(logIn.isLoggedIn());
    }
    // Katarina
    @Given("that the employee {string} is logged in")
    public void thatTheEmployeeIsLoggedIn(String initials) {
        Employee employee = new Employee(initials);
        logIn.loggingIn(employee, initials);
        assertTrue(logIn.isLoggedIn());
    }
    // Sophia
    @Then("the employee is already logged in")
    public void theEmployeeIsAlreadyLoggedIn() {
        assertTrue(logIn.isLoggedIn());
    }
    // Caroline
    @Given("that the employee {string} does not exist")
    public void thatTheEmployeeDoesNotExist(String initials) {
        assertFalse(database.employeeExists(initials));
    }
    // Katarina
    @When("the employee enters {string}")
    public void theEmployeeEnters(String enteredInitials) {
        logIn.loggingIn(employee, enteredInitials);
    }
}
