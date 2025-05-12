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
        When the employee creates a project with the title "Software_project"
        Then a project with the title "Software_project" is created

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
        Then the task "Coding" is created in the project
        And the task "Coding" has the starting week 20 and ending week 22

    Scenario: An employee creates a task in a project but there is a project leader
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is a project leader in the project 
        When the employee tries to create a task "Coding" using 50.0 hours starting in week 20 and ending in week 22 in the project
        Then the task "Coding" is not created in the project

    Scenario: An employee creates a task in a project with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project   
        When the employee tries to create a task "Coding" using 50.0 hours starting in week 60 and ending in week 62 in the project
        Then the task "Coding" is not created in the project

    Scenario: An employee creates a task in a project with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project   
        When the employee tries to create a task "Coding" using 50.0 hours starting in week -2 and ending in week 1 in the project
        Then the task "Coding" is not created in the project

    Scenario: An employee creates a task in a project with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project   
        When the employee tries to create a task "Coding" using 50.0 hours starting in week 40 and ending in week 62 in the project
        Then the task "Coding" is not created in the project

    Scenario: An employee creates a vacation task
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee creates a vacation task starting "2025-01-01" and ending "2025-01-10"
        Then the vacation task is created
    
    Scenario: An employee creates a sick leave task
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee creates a sick leave task starting "2025-01-01" and ending "2025-01-10"
        Then the sick leave task is created

    Scenario: An employee creates a course task
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee creates a course task starting "2025-01-01" and ending "2025-01-10"
        Then the course task is created

    Scenario: An employee wants to see their vacation list
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a vacation task starting "2025-01-01" and ending "2025-01-10"
        And the employee creates a vacation task starting "2025-02-01" and ending "2025-02-10"
        When the employee creates their vacation list
        Then the vacation list is shown

    Scenario: An employee wants to see their sick leave list
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a sick leave task starting "2025-01-01" and ending "2025-01-10"
        And the employee creates a sick leave task starting "2025-02-01" and ending "2025-02-10"
        When the employee creates their sick leave list
        Then the sick leave list is shown
    
    Scenario: An employee wants to see their course list
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a course task starting "2025-01-01" and ending "2025-01-10"
        And the employee creates a course task starting "2025-02-01" and ending "2025-02-10"
        When the employee creates their course list
        Then the course list is shown

    Scenario: An employee creates a task without a project number
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee creates a task "Coding" using 50.0 hours starting in week 20 and ending in week 22
        Then the task "Coding" is created
        And the task "Coding" has the starting week 20 and ending week 22

    Scenario: An employee creates a task without a project number with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee tries to create a task "Coding" using 50.0 hours starting in week 60 and ending in week 62
        Then the task "Coding" is not created

    Scenario: An employee creates a task without a project number with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd" 
        When the employee tries to create a task "Coding" using 50.0 hours starting in week -2 and ending in week 1
        Then the task "Coding" is not created

    Scenario: An employee creates a task without a project number with a non-valid week number
        Given the database is initialized
        And an employee is created with initials "abcd"
        When the employee tries to create a task "Coding" using 50.0 hours starting in week 40 and ending in week 62
        Then the task "Coding" is not created

    Scenario: Task with assigned employee displays correctly
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project without a title
        And there is no project leader in the project 
        When the employee creates a task "Coding" using 50.0 hours starting in week 20 and ending in week 22 in the project
        And the task is assigned to employee "abcd"
        Then the task string representation should be:
        """
        Task: Coding
          Duration: Week 20 - 22 (50.0 hours)
          Employee: abcd
          Status: Active
          Time Registrations: None
        """
    Scenario: An employee wants to see their course registration
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a course task starting "2025-01-01" and ending "2025-01-10"
        When the employee creates their course list
        Then the course list is shown
        And the course task string representation should be:
        """
        Course 2025-01-01 2025-01-10
          Duration: 2025-01-01 - 2025-01-10
          Status: Approved
        """

    Scenario: An employee wants to see their project list
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project with the title "Software_project"
        When the employee creates their project list
        Then the project list is shown
        And the project list string representation should be: 
        """
        Project Number: P-255
        Title: Software_project
        Project Leader: Not assigned
        Tasks: 0
        """

    Scenario: An employee wants to see their task list
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project with the title "Software_project"
        And the employee creates a task "Coding" using 50.0 hours starting in week 20 and ending in week 22 in the project
        When the employee creates their task list
        Then the task list is shown
        And the task list string representation should be: 
        """
        Task: Coding
          Duration: Week 20 - 22 (50.0 hours)
          Employee: Not assigned
          Status: Active
          Time Registrations: None
        """

    Scenario: An employee wnats to see the tasks they are assigned to
        Given the database is initialized
        And an employee is created with initials "abcd"
        And the employee creates a project with the title "Software_project"
        And the employee creates a task "Coding" using 50.0 hours starting in week 20 and ending in week 22 in the project
        When the employee creates their task list
        Then the assigned task list is shown
