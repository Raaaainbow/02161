# mob programming Sophia, Katarina, Sebastian

Feature: Employee login
   Description: Employee login to the application
   Actors: Employee

   Scenario: Employee can log in
      Given that the employee "abcd" exists
      And that the employee is not logged in
      When the employee enters "abcd"
      Then the employee "abcd" is logged in
      And the employee is redirected to the application

   Scenario: Employee cannot log in
      Given that the employee "abcd" exists
      And that the employee is not logged in
      When the employee enters "xyz"
      Then the employee "abcd" is not logged in
