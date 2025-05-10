package dtu.example.ui;

import dtu.example.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Database db = new Database();
        initialise(db, console);

        System.out.println("Enter a command (type 'help' to see a list of commands):");
            System.out.print(">");
        while (console.hasNextLine()) {
            String input = console.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Goodbye");
                break;
            }

            inputHandling(input, db);
            System.out.print(">");
        }

        console.close();
    }

    private static void initialise(Database db, Scanner console) {
        System.out.print("Enter initials: ");
        String input = console.nextLine().toLowerCase();
        Employee employee = db.getEmployee(input);
        LogIn login = new LogIn();
        login.loggingIn(employee, input);
    }

    private static void inputHandling(String input, Database db) {
        String[] parts = input.split("\\s+", 3);

        if (parts.length >= 3 && parts[0].equals("create") && parts[1].equals("project")) {
            String projectName = parts[2];
            db.createProject(projectName);
            System.out.println("project " + projectName + " created");
            return;
        }

        switch (input) {
            case "hello world":
                System.out.println("this is a test");
                break;

            case "help": 
                System.out.println("Here is a list of commands:");
                System.out.println("exit \t exits the program");
                System.out.println("create project PROJECTNAME \t creates a new project");
                break;

            default:
                System.out.println("Unknown command: " + input + " Type \"help\" to see commands");
        }
    }
}
