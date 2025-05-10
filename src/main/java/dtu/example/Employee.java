// mob programming Sophia, Katarina, Caroline

package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private boolean employeeExists = false;
    private Task task;
    private List<String> employeeList = new ArrayList<>();
    private String newInitials;
    private List<String> employeeListProject = new ArrayList<>();
    private boolean employeeInProject = false;
    private List<String> projectLeaderListProject = new ArrayList<>();
    private boolean taskExists;
    private List<Task> taskList = new ArrayList<>();
    //private List<Employee> employeeList = new Database().getEmployees();
    
    public Employee(String initials) {
        setInitials(initials);
        employeeList.add(initials);
        checkEmployeeExists(initials);
        employeeListProject.add(initials);
        checkEmployeeInProject(initials);
    }

    // public void addEmployeeToProject(String initials) {
    //     employeeListProject.add(initials);
    //     checkEmployeeInProject(initials);
    // }

    public boolean checkEmployeeExists(String initials) {
        this.employeeExists = employeeList.contains(initials);
        return employeeExists;
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

    public boolean checkEmployeeInProject(String initials) {
        return employeeListProject.contains(initials);
    }

    // public void checkEmployeeisProjectLeader(String initials) {
    // projectLeaderInProject = projectLeaderListProject.contains(initials);
    // }

    public boolean projectLeaderInProject() {
        return !projectLeaderListProject.isEmpty();
    }

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

    public void createTask(String title, int hours, int startWeek, int endWeek, String projectNumber) {
        Task task = new Task(title, hours, startWeek, endWeek, projectNumber); 
        taskList.add(task);
        this.task = task; 
    }

    public boolean taskExists(String title) {
        for (Task task : taskList) {
            if (task.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Task getTask() {
        return task;
    }

}