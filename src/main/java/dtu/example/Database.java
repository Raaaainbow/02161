// Sebastian
package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Database {

    List<Project> projects = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    private String projectNumber;
    private int counter = projects.size();
    private String year = "25";

    public Database() {
        initEmployees();
        initProjects();
    }

    private void initEmployees() {
        String[] initList = {"SFT", "SASS", "KHF", "CP", "HUBA"};
        for (int i = 0; i < initList.length; i++) {
            createEmployee(initList[i]);
        }

    }

    private void initProjects() {
        String[] initList = {"proj1", "proj2", "proj3", "proj4"};
        for (int i = 0; i < initList.length; i++) {
            createProject(initList[i]);
        }

    }

    public void createProject(String title) {
        Project proj = new Project(title);
        this.projectNumber = "P-" + year + counter;
        projects.add(proj);
    }

    public void createProject() {
        Project proj = new Project();
        this.projectNumber = "P-" + year + counter;
        projects.add(proj);
    }

    public boolean projectExistsTitle(String inputTitle) {
        for (Project project: projects) {
            if (project.getTitle() == inputTitle) {
                return true;
            }
        }
        return false;
    }

    public boolean projectExistsNumber(String projectNumber) {
        for (Project project: projects) {
            if (project.getProjectNumber() == projectNumber) {
                return true;
            }
        }
        return false;
    }

    public Project getProject(String title) {
        for (Project project: projects) {
            if (project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }

    public void createEmployee(String initials) {
        Employee employee = new Employee(initials);
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean employeeExists(String name) {
        for (Employee employee: employees) {
            if (employee.getInitials().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean employeeExists(Employee employee) {
        return employees.contains(employee);
    }
}
