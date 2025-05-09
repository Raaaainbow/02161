// mob programming Sophia, Katarina, Caroline

package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private boolean employeeExists = false; 
    private static List<String> employeeList = new ArrayList<>();
    private String newInitials;

    public Employee(String initials){
        setInitials(initials);
        employeeList.add(initials);
        checkEmployeeExists(initials);
    }

    public void checkEmployeeExists(String initials) {
        employeeExists = employeeList.contains(initials);
    }

    public Boolean employeeExists() {
        return employeeExists; 
    }

    public String changeInitials(String newInitials) {
        setInitials(newInitials);
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials; 
    }
}
