package dtu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dtu.example.Database;
import dtu.example.Employee;

public class DatabaseTest {

    @Test
    public void testEmployeeExists_MatchingInitials() {
        Database database = new Database();
        database.createEmployee("EET");
        assertTrue(database.employeeExists("EET"));
    }

    @Test
    public void testEmployeeExists_NullInput() {
        Database database = new Database();
        database.createEmployee("EET");
        assertFalse(database.employeeExists(null));
    }

    @Test
    public void testEmployeeExists_EmptyInput() {
        Database database = new Database();
        database.createEmployee("EET");
        assertFalse(database.employeeExists(""));
    }

    @Test
    public void testEmployeeExists_EmployeeWithNullInitials() {
        Database database = new Database();
        database.getEmployees().add(new Employee(null));
        database.createEmployee("EET");
        assertTrue(database.employeeExists("EET"));
    }

    @Test
    public void testEmployeeExists_NoMatch() {
        Database database = new Database();
        database.createEmployee("HPH");
        assertFalse(database.employeeExists("EET"));
    }
}
