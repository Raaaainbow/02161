// mob programming Sophia, Katarina, Caroline

package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private boolean employeeExists = false;
    private static List<String> employeeList = new ArrayList<>();
    private String newInitials;
    private static List<String> employeeListProject = new ArrayList<>();
    private boolean employeeExistsinproject = false;
    private static List<String> projectLeaderListProject = new ArrayList<>();
    private boolean projectLeaderExistsinproject = false;

    public Employee(String initials) {
        setInitials(initials);
        employeeList.add(initials);
        checkEmployeeExists(initials);
        employeeListProject.add(initials);
        checkEmployeeExistsinProject(initials);
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

    public void checkEmployeeExistsinProject(String initials) {
        employeeExistsinproject = employeeListProject.contains(initials);
    }

    public boolean employeeExistsinproject(String initials) {
        return employeeExistsinproject;
    }

    public void checkEmployeeisProjectLeader(String initials) {
        projectLeaderExistsinproject = projectLeaderListProject.contains(initials);
    }

    public boolean projectLeaderExistsinproject(String initials) {
        return employeeExistsinproject;
    }

    public boolean createTask(Project project, Task task) {
        return project.addTaskAsEmployee(this, task);
    }
}