package dtu.example.ui;

import dtu.example.backend.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class App {

    private static String currentEmployee;
    private static Employee currentEmployeeObject;
    private static final int maxTasks = 20;

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

            inputHandling(input, database, console);
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
            currentEmployeeObject = database.getEmployee(initials);
            
            if (currentEmployeeObject == null) {
                System.out.println("Employee not found. Please try again.");
                continue;
            }
            
            loginSuccessful = login.loggingIn(currentEmployeeObject, initials);
            
            if (loginSuccessful) {
                currentEmployee = initials;
            }
        }
    }

    private static void inputHandling(String input, Database database, Scanner console) {
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
                Employee currentEmployeeObject = database.getEmployee(currentEmployee);

                if (project.projectLeaderInProject() && !project.getProjectLead().equals(currentEmployee)) {
                System.out.println("Error: You are not the project leader of this project.");
                return;
                }

                if (currentEmployeeObject.getAssignedTasks().size() >= maxTasks) {
                   System.out.println("Error: Employee " + currentEmployee + " already has " + maxTasks +  " tasks assigned.");
                    return;
                }
                // Create task only in project

                Task newTask = project.createTask(title, hours, startWeek, endWeek, projectNumber);
                
                // Add the same task to current employee
                currentEmployeeObject.addTask(newTask);
                newTask.setAssignedEmployee(currentEmployeeObject);

                System.out.println("Task '" + title + "' created successfully for project " + projectNumber);

                return;
            } catch (NumberFormatException e) {
                System.out.println("Error: HOURS, STARTWEEK, and ENDWEEK must be numbers.");
                System.out.println("Usage: create task TITLE HOURS STARTWEEK ENDWEEK PROJECTNUMBER");
                return;
            }
        }

        if (parts[0].equals("edit") && parts[1].equals("task")) {
            try {
            String taskTitle = parts[2];
            
            Employee currentEmployeeObject = database.getEmployee(currentEmployee);
            List<Task> tasks = currentEmployeeObject.getAssignedTasks();
            Task taskToEdit = null;
            
            for (Task task : tasks) {
                if (task.getTitle().equals(taskTitle)) {
                    taskToEdit = task;
                    break;
                }
            }
            
            if (taskToEdit == null) {
                System.out.println("Error: Task " + taskTitle + " not found in your assigned tasks");
                return;
            }
            
            System.out.println("What would you like to edit?");
            System.out.println("1. Task hours");
            System.out.println("2. Start week");
            System.out.println("3. End week");
            System.out.println("Enter choice (1-3): ");
            
            String choice = console.nextLine();
            
            switch(choice) {
                case "1":
                    System.out.print("Enter new hours: ");
                    try {
                        double newHours = Double.parseDouble(console.nextLine());
                        if (newHours <= 0) {
                            System.out.println("Error: Hours must be positive");
                            return;
                        }
                        taskToEdit.setEstimatedTime(newHours);
                        System.out.println("Hours updated successfully");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format");
                    }
                    break;
                case "2":
                    System.out.print("Enter new start week: ");
                    try {
                        int newStartWeek = Integer.parseInt(console.nextLine());
                        if (newStartWeek <= 0 || newStartWeek > 52) {
                            System.out.println("Error: Start week must be between 1 and 52");
                            return;
                        }
                        taskToEdit.setStartWeek(newStartWeek);
                        System.out.println("Start week updated successfully");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format");
                    }
                    break;
                case "3":
                    System.out.print("Enter new end week: ");
                    try {
                        int newEndWeek = Integer.parseInt(console.nextLine());
                        if (newEndWeek <= 0 || newEndWeek > 52) {
                            System.out.println("Error: End week must be between 1 and 52");
                            return;
                        }
                        taskToEdit.setEndWeek(newEndWeek);
                        System.out.println("End week updated successfully");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        return;
        
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: Usage: edit task TASK_TITLE");
    }
}

        if (parts[0].equals("register") && parts[1].equals("time")) {
            try {
                String taskName = parts[2];
                double hours = Double.parseDouble(parts[3]);
                LocalDate date = LocalDate.parse(parts[4]);
                
                if (currentEmployeeObject == null) {
                    System.out.println("Error: Not logged in");
                    return;
                }
                
                TimeRegistration time = new TimeRegistration(hours, currentEmployee, date);
                List<Task> tasks = currentEmployeeObject.getAssignedTasks();
                boolean taskFound = false;
                
                for (Task task : tasks) {
                    if (task.getTitle().equals(taskName)) {
                        task.addTimeRegistration(time);
                        taskFound = true;
                        break;
                    }
                }
                
                if (!taskFound) {
                    System.out.println("Error: Task not found or not assigned to you");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: time format is incorrect");
            }
            return;
        }
        // Caroline
        if (parts[0].equals("register") && parts[1].equals("vacation")) {
            if (parts.length < 4) {
                System.out.println("Error: Not enough arguments for vacation registration.");
                System.out.println("Usage: register vacation STARTDATE ENDDATE");
                return;
            }

            try {
                LocalDate startDate = LocalDate.parse(parts[2]);
                LocalDate endDate = LocalDate.parse(parts[3]);
                Employee employee = database.getEmployee(currentEmployee);
                employee.createVacation(startDate, endDate);
                System.out.println("Vacation registered successfully from " + startDate + " to " + endDate);

            } catch (DateTimeParseException e) {
                System.out.println("Error: Date format is incorrect.");
                System.out.println("STARTDATE and ENDDATE must be in format: yyyy-MM-dd");
                System.out.println("Usage: register vacation STARTDATE ENDDATE");
            }
            return;
        }
        // Katarina
        if (parts[0].equals("register") && parts[1].equals("sick") && parts[2].equals("leave")) {
            if (parts.length < 4) {
                System.out.println("Error: Not enough arguments for sick leave registration.");
                System.out.println("Usage: register sick leave STARTDATE ENDDATE");
                return;
            }

            try {
                LocalDate startDate = LocalDate.parse(parts[3]);
                LocalDate endDate = LocalDate.parse(parts[4]);
                Employee employee = database.getEmployee(currentEmployee);
                employee.createSickLeave(startDate, endDate);
                System.out.println("Sick leave registered successfully from " + startDate + " to " + endDate);
                
            } catch (DateTimeParseException e) {
                System.out.println("Error: Date format is incorrect.");
                System.out.println("STARTDATE and ENDDATE must be in format: yyyy-MM-dd");
                System.out.println("Usage: register sick leave STARTDATE ENDDATE");
            }
            return;
        }
        // Sophia
        if (parts[0].equals("register") && parts[1].equals("course")) {
            if (parts.length < 4) {
                System.out.println("Error: Not enough arguments for course registration.");
                System.out.println("Usage: register course STARTDATE ENDDATE");
                return;
            }

            try {
                LocalDate startDate = LocalDate.parse(parts[2]);
                LocalDate endDate = LocalDate.parse(parts[3]);
                Employee employee = database.getEmployee(currentEmployee);
                employee.createCourse(startDate, endDate);
                System.out.println("Course registered successfully from " + startDate + " to " + endDate);
                return;
                
            } catch (DateTimeParseException e) {
                System.out.println("Error: Date format is incorrect.");
                System.out.println("STARTDATE and ENDDATE must be in format: yyyy-MM-dd");
                System.out.println("Usage: register course STARTDATE ENDDATE");
            }
        }

        if (parts[0].equals("list") && parts[1].equals("projects")) {
            List<Project> projects = database.getProjects();

            for (Project project: projects) {
                System.out.println(project.toString());
            }
            return;
        }
        
        if (parts[0].equals("list") && parts[1].equals("employees")) {
            List<Employee> employees = database.getEmployees();
            String output = "";

            for (Employee employee: employees) {
                output += employee.getInitials() + " ";
            }
            System.out.println(output);
            return;
        }

        if (parts[0].equals("create") && parts[1].equals("time") && parts[2].equals("registration")) {

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
           return;
        }

        if (parts[0].equals("assign") && parts[1].equals("task")) {
            try {
                String taskTitle = parts[2];
                String oldInitials = parts[3];
                String NewInitials = parts[4];

                Employee oldEmployee = database.getEmployee(oldInitials);
                if (oldEmployee == null) {
                    System.out.println("Error: Employee " + oldInitials + " not found");
                    return;
                }
                
                List<Task> tasks = oldEmployee.getAssignedTasks();
                boolean taskFound = false;
                for (Task task: tasks) {
                    if (task.getTitle().equals(taskTitle)) {
                        Employee newEmployee = database.getEmployee(NewInitials);
                        if (newEmployee == null) {
                            System.out.println("Error: Employee " + NewInitials + " not found");
                            return;
                        }
                        if (newEmployee.getAssignedTasks().size() >= maxTasks) {
                           System.out.println("Error: Employee " + currentEmployee + " already has " + maxTasks +  " tasks assigned.");
                            return;
                        } 
                        System.out.println("assigning new employee");
                        task.setAssignedEmployee(newEmployee);
                        newEmployee.addTask(task);
                        
                        oldEmployee.getAssignedTasks().remove(task);
                        taskFound = true;
                        break;
                    }
                }
                
                if (!taskFound) {
                    System.out.println("Task " + taskTitle + " does not exist");
                }
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Usage: assign task TASK_TITLE OLD_EMPLOYEE_INITIALS NEW_EMPLOYEE_INITIALS");
            }
            return;
        }
        // Caroline
        if (parts[0].equals("view") && parts[1].equals("vacation")) {
            Employee employee = database.getEmployee(currentEmployee);
            List<Task> vacationList = employee.getVacationList();

            if (vacationList.isEmpty()) {
                System.out.println("No vacation registered.");
                return;
            }

            System.out.println("Vacation overview for " + currentEmployee + ":");

            for (Task vacation : vacationList) {
                System.out.println(vacation.toString2());
            }
            return;
        }
        // Katarina
        if (parts[0].equals("view") && parts[1].equals("sick") && parts[2].equals("leave")) {
            Employee employee = database.getEmployee(currentEmployee);
            List<Task> sickLeaveList = employee.getSickLeaveList();

            if (sickLeaveList.isEmpty()) {
                System.out.println("No sick leave registered.");
                return;
            }

            System.out.println("Sick leave overview for " + currentEmployee + ":");

            for (Task sickLeave : sickLeaveList) {
                System.out.println(sickLeave.toString2());
            }
            return;
        }
        // Sophia
        if (parts[0].equals("view") && parts[1].equals("course")) {
            Employee employee = database.getEmployee(currentEmployee);
            List<Task> courseList = employee.getCourseList();

            if (courseList.isEmpty()) {
                System.out.println("No courses registered.");
                return;
            }

            System.out.println("Course overview for " + currentEmployee + ":");

            for (Task course : courseList) {
                System.out.println(course.toString2());
            }
            return;
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
            return;
        }
        
        if (parts[0].equals("edit") && parts[1].equals("project")) {
           try {
               String projectNumber = parts[2].toUpperCase();
               Project project = database.getProjectByNumber(projectNumber);
               
               if (project == null) {
                   System.out.println("Error: Project " + projectNumber + " not found");
                   return;
               }
               
               System.out.println("What would you like to edit?");
               System.out.println("1. Project title");
               System.out.println("2. Project leader");
               System.out.println("Enter choice (1-2): ");
               
               String choice = console.nextLine();
               
               switch(choice) {
                   case "1":
                       System.out.print("Enter new title: ");
                       String newTitle = console.nextLine();
                       project.setTitle(newTitle);
                       System.out.println("Title updated successfully");
                       break;
                   case "2":
                       System.out.print("Enter new leader initials: ");
                       String newLeader = console.nextLine();
                       project.setProjectLead(newLeader);
                       System.out.println("Leader updated successfully");
                       break;
                   default:
                       System.out.println("Invalid choice");
                       return;
               }
            return;
               
           } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("Error: Usage: edit project PROJECTNUMBER");
           }
        }

        if (parts[0].equals("help")) {
            System.out.println("\n=== AVAILABLE COMMANDS ===");
            System.out.println("exit\n    Exits the program");
            System.out.println("\nassign project leader PROJECTNUMBER INITIALS");
            System.out.println("    Assigns a project leader to specified project");
            System.out.println("\nassign task TASK_TITLE OLD_INITIALS NEW_INITIALS");
            System.out.println("    Reassigns a task from one employee to another");
            System.out.println("\nedit project PROJECTNUMBER");
            System.out.println("    Edits project title or leader");
            System.out.println("\ncreate project [PROJECTNAME]");
            System.out.println("    Creates a new project with optional name");
            System.out.println("\ncreate task TITLE HOURS STARTWEEK ENDWEEK PROJECTNUMBER");
            System.out.println("    Creates a new task for specified project");
            System.out.println("\nedit task TASK_TITLE");
            System.out.println("    Edits task hours, start week, or end week");
            System.out.println("\nregister time TASKNAME HOURS DATE");
            System.out.println("    Registers time for specified task (format: yyyy-MM-dd)");
            System.out.println("\nregister vacation STARTDATE ENDDATE");
            System.out.println("    Registers vacation for the current employee");
            System.out.println("\nregister sick leave STARTDATE ENDDATE");
            System.out.println("    Registers sick leave for the current employee");
            System.out.println("\nregister course STARTDATE ENDDATE");
            System.out.println("    Registers course for the current employee");
            System.out.println("\nlist employees");
            System.out.println("    Lists all employee initials from the database");
            System.out.println("\nlist projects");
            System.out.println("    Lists project numbers from the database");
            System.out.println("\nview time registration [PROJECTNUMBER]");
            System.out.println("    Views tasks for current employee or specified project");
            System.out.println("\nview vacation");
            System.out.println("    Views vacation for the current employee");
            System.out.println("\nview sick leave");
            System.out.println("    Views sick leave for the current employee");
            System.out.println("\nview course");
            System.out.println("    Views course for the current employee");
            System.out.println("\nhelp");
            System.out.println("    Displays this command list");
            System.out.println("\n=========================\n");
            return;
        }

        System.out.println("Unknown command '" + input + "' type 'help' to see available commands.");
    }
}
