# mob programming Caroline, Sophia, Katarina

Feature: Project Management in the Database
    Description: Managing the informations in database
    Actor: Employee
    
    Scenario: Getting a list of all employees
        Given the database has been initialized
        When an employee "abcd" requests a list of all employees
        Then the employee gets a list of all employees
