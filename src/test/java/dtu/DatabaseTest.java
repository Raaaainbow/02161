// Sebastian

package dtu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dtu.example.backend.Database;
import dtu.example.backend.Employee;

public class DatabaseTest {
    // Sebastian
    @Test
    public void testEmployeeExists_MatchingInitials() {
        Database database = new Database();
        database.createEmployee("EET");
        assertTrue(database.employeeExists("EET"));
    }
    // Sebastian
    @Test
    public void testEmployeeExists_NullInput() {
        Database database = new Database();
        database.createEmployee("EET");
        assertFalse(database.employeeExists(null));
    }
    // Sebastian
    @Test
    public void testEmployeeExists_EmptyInput() {
        Database database = new Database();
        database.createEmployee("EET");
        assertFalse(database.employeeExists(""));
    }
    // Sebastian
    @Test
    public void testEmployeeExists_EmployeeWithNullInitials() {
        Database database = new Database();
        database.getEmployees().add(new Employee(null));
        database.createEmployee("EET");
        assertTrue(database.employeeExists("EET"));
    }
    // Sebastian
    @Test
    public void testEmployeeExists_NoMatch() {
        Database database = new Database();
        database.createEmployee("HPH");
        assertFalse(database.employeeExists("EET"));
    }
}
