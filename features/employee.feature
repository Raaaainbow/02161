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