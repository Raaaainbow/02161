// mob programming Sophia, Caroline, Katarina

package hellocucumber;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import io.cucumber.java.en.*;

import dtu.example.Database;
import dtu.example.Employee;

public class DatabaseSteps {

    private Database database;
    private List<Employee> employeeList;

    @Given("the database has been initialized")
    public void theDatabaseHasBeenInitialized() {
        database = new Database();
    }

    @When("an employee {string} requests a list of all employees")
    public void anEmployeeRequestsAListOfAllEmployees(String initials) {
        this.employeeList = database.getEmployees();
    }
    
    @Then("the employee gets a list of all employees")
    public void theEmployeeGetsAListOfAllEmployees() {
        assertNotNull(employeeList);
    }
}
