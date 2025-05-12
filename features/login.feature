
Feature: Employee login
   Description: Employee login to the application
   Actors: Employee
   # Katarina
   Scenario: Employee can log in
      Given that the database is initialized 
      And that the employee "abcd" exists
      And that the employee is not logged in
      When the employee "abcd" enters "abcd"
      Then the employee is logged in
      And the employee is redirected to the application
   # Sophia
   Scenario: Employee cannot log in
      Given that the database is initialized 
      And that the employee "abcd" exists
      And that the employee is not logged in
      When the employee "abcd" enters "xyz"
      Then the employee is not logged in
   # Sebastian
   Scenario: Employee is already logged in
      Given that the database is initialized 
      And that the employee "abcd" exists
      And that the employee "abcd" is logged in
      When the employee "abcd" enters "abcd"
      Then the employee is already logged in
   # Katarina
   Scenario: Employee does not exists
      Given that the database is initialized 
      And that the employee "xyz" does not exist
      When the employee enters "xyz"
      Then the employee is not logged in


