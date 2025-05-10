// Sebastian
package dtu.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private List<Project> projects = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<String> emploeesString = new ArrayList<>();
    private Map<String, Employee> employeesHash = new HashMap<>();
    private String year = "25";
    private String projectNumber;

    public Database() {
        initEmployees();
        initProjects();
    }

    private void initEmployees() {
        String[] initList = {"sft", "sass", "khf", "cp", "huba"};
        for (int i = 0; i < initList.length; i++) {
            Employee employee = new Employee(initList[i]);
            employeesHash.put(initList[i], employee);
            emploeesString.add(initList[i]);
            employees.add(employee);
        }
    }

    private void initProjects() {
        String[] initList = {"proj1", "proj2", "proj3", "proj4"};
        for (int i = 0; i < initList.length; i++) {
            Project project = new Project(initList[i]);
            projects.add(project);
        }

    }

    public void createProject(String title) {
        projectNumber = "P-" + year + (projects.size()+1);
        Project proj = new Project(title, projectNumber);
        projects.add(proj);
    }

    public void createProject() {
        projectNumber = "P-" + year + (projects.size()+1);
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
        emploeesString.add(initials);
        employees.add(employee);
        employeesHash.put(initials, employee);
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

    public Employee getEmployee(String initials) {
        return employeesHash.get(initials);
    }

    public boolean employeeExists(Employee employee) {
        return employees.contains(employee);
    }

    
}
