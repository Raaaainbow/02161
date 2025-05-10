// Sebastian
package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Database {

    List<Project> projects = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    private int counter = projects.size();
    private String year = "25";
    private String projectNumber;

    public Database() {
        initEmployees();
        initProjects();
    }

    private void initEmployees() {
        String[] initList = {"sft", "sass", "khf", "cp", "huba"};
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
        projectNumber = "P-" + year + counter;
        Project proj = new Project(title, projectNumber);
        projects.add(proj);
    }

    public void createProject() {
        projectNumber = "P-" + year + counter;
        Project proj = new Project(projectNumber);
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

    public List<Project> getProjects() {
        return projects;
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

    public Employee getEmployee(String iD) {
        for (Employee employee: employees) {
            if (employee.getInitials().equals(iD)) {
                return employee;
            }
        }
        return null;
    }

    public boolean employeeExists(Employee employee) {
        return employees.contains(employee);
    }

    
}
