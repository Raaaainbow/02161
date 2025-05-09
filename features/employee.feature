# mob programming Sophia, Katarina, Caroline

Feature: Employee 
    Description: 
    Actor: Employee

    Scenario: Employee exists in the Database
        Given an employee is created with initials "abcd" 
        Then the employee "abcd" exists in the Database 

    Scenario: Employee does not exist in the Database
        Given an employee is created with initials "abcd"
        Then the employee "efgh" does not exist in the Database

    Scenario: Employee changes their initials
        Given an employee has the initials "abcd"
        When the employee change their initials to "efgh"
        Then the employee has the initials "efgh"

    Scenario: Employee creates project with a title
        Given an employee is created with initials "abcd"
        When the employee creates a project with the title "Byggeprojekt"
        Then a project with the title "Byggeprojekt" is created

    Scenario: Employee creates project without a title
        Given an employee is created with initials "abcd"
        When the employee creates a project without a title
        Then a project without a title is created with the project number "P-255"

    # Scenario: An employee creates a task in a project
    #     Given the employee "abcd" exists in the Database for the given project
    #     And there is no project leader in the project 
    #     When the employee creates a task in the project
    #     Then the task is created 

    # Scenario: An employee creates a task in a project but there is a project leader
    #     Given the employee "abcd" exists in the Database for the given project
    #     And there is a project leader in the project 
    #     When the employee creates a task in the project
    #     Then the task is not created and an error message occurs 