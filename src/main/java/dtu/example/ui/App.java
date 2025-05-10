package dtu.example.ui;

import dtu.example.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;


public class App {

    private static Employee currentEmployee;

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
                currentEmployee = employee;
            }
        }
    }

    private static void inputHandling(String input, Database database) {
        String[] parts = input.split("\\s+");

        if (parts[0].equals("create") && parts[1].equals("project")) {
            if (parts.length >= 3) {
                String projectName = parts[2];
                database.createProject(projectName);
                System.out.println("project " + projectName + " created");
            } else {
                database.createProject();
                System.out.println("project " + database.getProjects().getLast().getProjectNumber() + " created");
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
                int hours = Integer.parseInt(parts[3]);
                int startWeek = Integer.parseInt(parts[4]);
                int endWeek = Integer.parseInt(parts[5]);
                String projectNumber = parts[6];
                
                Task task = new Task(title, hours, startWeek, endWeek, projectNumber);
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
        }

        if (parts[0].equals("help")) {
                System.out.println("\n=== AVAILABLE COMMANDS ===");
                System.out.println("exit\n    Exits the program");
                System.out.println("\ncreate project [PROJECTNAME]");
                System.out.println("    Creates a new project with optional name");
                System.out.println("\ncreate task TITLE HOURS STARTWEEK ENDWEEK PROJECTNUMBER");
                System.out.println("    Creates a new task for specified project");
                System.out.println("\nlist projects");
                System.out.println("    lists project numbers from the database");
                System.out.println("\nhelp");
                System.out.println("    Displays this command list");
                System.out.println("\n=========================\n");
        }
    }
}
