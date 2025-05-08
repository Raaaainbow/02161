package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private boolean employeeExists = false; 
    private static List<String> employeeList = new ArrayList<>();

    public Employee(String initials){
        this.initials = initials; 

        checkEmployeeExists(initials);
    }

    public void checkEmployeeExists(String initials) {
        if (employeeList.contains(initials)) {
            employeeExists = true; 
        }
    }

    public Boolean employeeExists() {
    return employeeExists; 
    }

    public String getInitials() {
        return initials; 
    }
}
