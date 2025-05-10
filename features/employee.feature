# mob programming Sophia, Katarina, Caroline

Feature: Employee 
    Description: 
    Actor: Employee

    Scenario: Employee exists in the Database
        Given the database is initialized
        And an employee is created with initials "abcd"
        Then the employee "abcd" exists in the Database 

    Scenario: Employee does not exist in the Database
        Given the database is initialized
        And an employee is created with initials "abcd"
        Then the employee "efgh" does not exist in the Database

    Scenario: Employee changes their initials
        Given the database is initialized
        And an employee has the initials "abcd"
        When the employee change their initials to "efgh"
        Then the employee has the initials "efgh"

    Scenario: Employee creates project with a title
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee creates a project with the title "Software project"
        Then a project with the title "Software project" is created

    Scenario: Employee creates project without a title
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee creates a project without a title
        Then a project without a title is created with the project number "P-255"
        And the project has the project number "P-255"

    Scenario: An employee creates a task in a project
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project   
        When the employee creates a task "Coding" using 50 hours starting in week 20 and ending in week 22 in the project
        Then the task "Coding" is created
        And the activity "Coding" has the starting week 20 and ending week 22

    Scenario: An employee creates a task in a project but there is a project leader
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is a project leader in the project 
        When the employee tries to create a task "Coding" using 50 hours starting in week 20 and ending in week 22 in the project
        Then the task "Coding" is not created

    Scenario: An employee creates a task in a project with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project   
        When the employee tries to create a task "Coding" using 50 hours starting in week 60 and ending in week 62 in the project
        Then the task "Coding" is not created

    Scenario: An employee creates a task in a project with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project   
        When the employee tries to create a task "Coding" using 50 hours starting in week -2 and ending in week 0 in the project
        Then the task "Coding" is not created

    
        