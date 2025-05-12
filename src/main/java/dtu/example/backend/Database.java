package dtu.example.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private List<Project> projects = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<String> employeesString = new ArrayList<>();
    private Map<String, Employee> employeesHash = new HashMap<>();
    private String year = "25";
    private String projectNumber;
    // Caroline
    public Database() {
        initEmployees();
        initProjects();
    }
    // Sophia
    private void initEmployees() {
        String[] initList = {"sft", "sass", "khf", "cp", "huba"};
        for (int i = 0; i < initList.length; i++) {
            Employee employee = new Employee(initList[i]);
            employeesHash.put(initList[i], employee);
            employeesString.add(initList[i]);
            employees.add(employee);
        }
    }
    // Sebastian
    private void initProjects() {
        String[] initList = {"P-251", "P-252", "P-253", "P-254"};
        for (int i = 0; i < initList.length; i++) {
            Project project = new Project(initList[i]);
            projects.add(project);
        }
        getProjectByNumber("P-251").setTitle("Vacation");
        getProjectByNumber("P-252").setTitle("Sick Leave");
        getProjectByNumber("P-253").setTitle("Course");
    }
    // Katarina
    public void createProject(String title) {
        projectNumber = "P-" + year + (projects.size()+1);
        Project proj = new Project(title, projectNumber);
        projects.add(proj);
    }
    // Caroline
    public void createProject() {
        projectNumber = "P-" + year + (projects.size()+1);
        Project proj = new Project(projectNumber);
        projects.add(proj);
    }
    // Sophia
    public Project getProjectByNumber(String projectNumber) {
        for (Project proj : projects) {
            if (proj.getProjectNumber().equals(projectNumber)) {
                return proj;
            }
        }
        return null;
    }
    // Sebastian
    public boolean projectExistsTitle(String inputTitle) {
        for (Project project: projects) {
            if (project.getTitle() != null && project.getTitle().equals(inputTitle)) {
                return true;
            }
        }
        return false;
    }
    // Katarina
    public boolean projectExistsNumber(String projectNumber) {
        for (Project project : projects) {
            if (project.getProjectNumber() != null && project.getProjectNumber().equals(projectNumber)) {
                return true;
            }
        }
        return false;
    }
    // Caroline
    public Project getProject(String title) {
        for (Project project: projects) {
            if (project.getTitle() != null && project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }
    // Sophia
    public List<Project> getProjects() {
        return projects;
    }
    // Sebastian
    public void createEmployee(String initials) {
        Employee employee = new Employee(initials);
        employeesString.add(initials);
        employees.add(employee);
        employeesHash.put(initials, employee);
    }
    // Katarina
    public List<Employee> getEmployees() {
        return employees;
    }
    // Caroline
    public boolean employeeExists(String initials) {
        if (initials == null || initials.isEmpty()) {
        return false; 
        }

        for (Employee employee: employees) {
            if (employee.getInitials() != null && employee.getInitials().equals(initials)) {
                return true;
            }
        }
        return false;
    }
    // Sophia
    public Employee getEmployee(String initials) {
        return employeesHash.get(initials);
    }
}
