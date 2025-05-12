// mob programming Katarina, Sophia, Sebastian, Caroline

package dtu.example.ui;

import dtu.example.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;


public class App {

    private static String currentEmployee;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Database database = new Database();
        initialise(database, console);

        System.out.println("Enter a command (type 'help' to see a list of commands):");
            System.out.print("> ");
        while (console.hasNextLine()) {
            String input = console.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Goodbye");
                break;
            }

            inputHandling(input, database);
            System.out.print("> ");
        }

        console.close();
    }

    private static void initialise(Database database, Scanner console) {
        LogIn login = new LogIn();
        boolean loginSuccessful = false;
        
        while (!loginSuccessful) {
            System.out.print("Enter initials: ");
            String initials = console.nextLine().toLowerCase();
            Employee employee = database.getEmployee(initials);
            
            if (employee == null) {
                System.out.println("Employee not found. Please try again.");
                continue;
            }
            
            loginSuccessful = login.loggingIn(employee, initials);
            
            if (loginSuccessful) {
                currentEmployee = initials;
            }
        }
    }

    private static void inputHandling(String input, Database database) {
        String[] parts = input.split("\\s+");

        if (parts[0].equals("create") && parts[1].equals("project")) {
            if (parts.length >= 3) {
                String projectName = parts[2].toUpperCase();
                database.createProject(projectName);
                System.out.println("project " + projectName + " created with project number " + database.getProject(projectName).getProjectNumber());
            } else {
                database.createProject();
                System.out.println("project created with project number " + database.getProjects().getLast().getProjectNumber());
            }
            return;
        }
        
        if (parts[0].equals("create") && parts[1].equals("task")) {
            if (parts.length < 7) {
                System.out.println("Error: Not enough arguments for task creation.");
                System.out.println("Usage: create task TITLE HOURS STARTWEEK ENDWEEK PROJECTNUMBER");
                return;
            }
            
            try {
                String title = parts[2];
                double hours = Double.parseDouble(parts[3]);
                int startWeek = Integer.parseInt(parts[4]);
                int endWeek = Integer.parseInt(parts[5]);
                String projectNumber = parts[6].toUpperCase().trim();
                
                // Kommentar
                if ((startWeek <= 0 || startWeek > 52) && (endWeek <= 0 || endWeek > 52)) {
                    System.out.println("Error: Start and end week must be between 1 and 52.");
                    return;
                }

                if (startWeek <= 0 || startWeek > 52) {
                    System.out.println("Error: Start week must be between 1 and 52.");
                    return;
                }

                if (endWeek <= 0 || endWeek > 52) {
                    System.out.println("Error: End week must be between 1 and 52.");
                    return;
                }

                if (hours <= 0.0) {
                    System.out.println("Error: Hours must be a positive number larger .");
                    return;
                }

                Project project = database.getProjectByNumber(projectNumber);
                if (!database.projectExistsNumber(projectNumber)) {
                    System.out.println("Error: Project with number " + projectNumber + " does not exist.");
                    return;
                }

                project.createTask(title, hours, startWeek, endWeek, projectNumber);
                Employee currentEmployeeObject = database.getEmployee(currentEmployee);
                currentEmployeeObject.createTask(title, hours, startWeek, endWeek);
                System.out.println("Task '" + title + "' created successfully for project " + projectNumber);

                return;
            } catch (NumberFormatException e) {
                System.out.println("Error: HOURS, STARTWEEK, and ENDWEEK must be numbers.");
                System.out.println("Usage: create task TITLE HOURS STARTWEEK ENDWEEK PROJECTNUMBER");
                return;
            }
        }

        if (parts[0].equals("create") && parts[1].equals("time") && parts[2].equals("registration")) {
            if (parts.length < 6) {
                System.out.println("Error: Not enough arguments for time registration.");
                System.out.println("Usage: create time registration SHIFTSTART SHIFTEND DATE");
                return;
            }
            
            try {
                // Parse LocalDateTime from strings
                LocalDateTime shiftStart = LocalDateTime.parse(parts[3]);
                LocalDateTime shiftEnd = LocalDateTime.parse(parts[4]);
                LocalDate date = LocalDate.parse(parts[5]);
                
                System.out.println("This feature has yet to be implemented");
                // add time registration code here!
                System.out.println("Time registration created successfully");
                
            } catch (DateTimeParseException e) {
                System.out.println("Error: Date/time format is incorrect.");
                System.out.println("SHIFTSTART and SHIFTEND must be in format: yyyy-MM-ddTHH:mm:ss");
                System.out.println("DATE must be in format: yyyy-MM-dd");
                System.out.println("Usage: create time registration SHIFTSTART SHIFTEND DATE");
            }
        }

        if (parts[0].equals("list") && parts[1].equals("projects")) {
            List<Project> projects = database.getProjects();
            String str = "";

            for (Project project: projects) {
                str += project.getProjectNumber() + " ";
            }
            System.out.println(str);
        }
        
        if (parts[0].equals("list") && parts[1].equals("employees")) {
            List<Employee> employees = database.getEmployees();
            String output = "";

            for (Employee employee: employees) {
                output += employee.getInitials() + " ";
            }
            System.out.println(output);
        }

        if (parts[0].equals("view") && parts[1].equals("time") && parts[2].equals("registration")) {
           String projectNumber = parts.length > 3 ? parts[3].toUpperCase() : null;

           Employee employee = database.getEmployee(currentEmployee);

           if (projectNumber == null) {
               List<Task> tasks = employee.getAssignedTasks();                
               for (Task task: tasks) {
                   System.out.println(task.toString());
               }
           } else {
               Project project = database.getProjectByNumber(projectNumber);
               List<Task> tasks =  project.getTasks();
               for (Task task: tasks) {
                   System.out.println(task.toString());
               }
           }
        }

        if (parts[0].equals("assign") && parts[1].equals("project") && parts[2].equals("leader")) {
            try {
                String projectNumber = parts[3].toUpperCase();
                String initials = parts[4];

                System.out.println(projectNumber + " " + initials);

                Project project = database.getProjectByNumber(projectNumber);
                if (project != null) {
                    project.makeProjectLeader(initials);
                    System.out.println("Employee " + initials + " has been set as project leader on the project " + projectNumber);
                } else {
                    System.out.println("Error project " + projectNumber + " does not exist");
                }


            } catch (IllegalArgumentException e) {
                System.out.println("Error: PROJECTNUMBER invalid");
                System.out.println("Error: INITIALS invalid");
            }
            
        }

        if (parts[0].equals("help")) {
            System.out.println("\n=== AVAILABLE COMMANDS ===");
            System.out.println("exit\n    Exits the program");
            System.out.println("\nassign project leader PROJECTNUMBER INITIALS");
            System.out.println("    Assigns a project leader to specified project");
            System.out.println("\ncreate project [PROJECTNAME]");
            System.out.println("    Creates a new project with optional name");
            System.out.println("\ncreate task TITLE HOURS STARTWEEK ENDWEEK PROJECTNUMBER");
            System.out.println("    Creates a new task for specified project");
            System.out.println("\ncreate time registration SHIFTSTART SHIFTEND DATE");
            System.out.println("    Creates a time registration (not yet implemented)");
            System.out.println("\nlist employees");
            System.out.println("    Lists all employee initials from the database");
            System.out.println("\nlist projects");
            System.out.println("    Lists project numbers from the database");
            System.out.println("\nview time registration");
            System.out.println("    Views time registration (not yet implemented)");
            System.out.println("\nhelp");
            System.out.println("    Displays this command list");
            System.out.println("\n=========================\n");
        }
    }
}
