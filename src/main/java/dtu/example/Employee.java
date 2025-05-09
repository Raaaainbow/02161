// mob programming Sophia, Katarina, Caroline

package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private boolean employeeExists = false;
    private List<String> employeeList = new ArrayList<>();
    private String newInitials;
    private List<String> employeeListProject = new ArrayList<>();
    private boolean employeeInProject = false;
    private List<String> projectLeaderListProject = new ArrayList<>();
    private boolean projectLeaderInProject = false;

    public Employee(String initials) {
        setInitials(initials);
        employeeList.add(initials);
        checkEmployeeExists(initials);
        employeeListProject.add(initials);
        checkEmployeeInProject(initials);
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

    public void checkEmployeeInProject(String initials) {
        employeeInProject = employeeListProject.contains(initials);
    }

    // public boolean employeeInProject() {
    //     return employeeInProject;
    // }

    // public void checkEmployeeisProjectLeader(String initials) {
    //     projectLeaderInProject = projectLeaderListProject.contains(initials);
    // }

    // public boolean projectLeaderIsInProject(String initials) {
    //     return employeeInProject;
    // }

    // public boolean getProjectLeaderInProject() {
    //     return projectLeaderInProject;
    // }

    public void createProjectWithTitle(String title) {
        Database database = new Database();
        database.createProject(title);
    }

    public void createProject() {
        Database database = new Database();
        database.createProject();
    }

    public boolean projectExistsTitle(String title) {
        Database database = new Database();
        return database.projectExistsTitle(title); 
    }

    public boolean projectExistsNumber(String number) {
        Database database = new Database();
        return database.projectExistsNumber(number); 
    }
}