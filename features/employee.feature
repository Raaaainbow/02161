# mob programming Sophia, Katarina, Caroline

Feature: Employee 
    Description: 
    Actor: Employee

    Scenario: Employee exists in the Database
        Given an employee is created with initials "abcd" 
        Then the employee exists in the Database 
        And has the initials "abcd" 

    Scenario: Employee does not exist in the Database
        Given an employee is created with initials "abcd"
        Then the employee "efgh" does not exist in the Database