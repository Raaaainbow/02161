Feature: Employee login
   Description: Employee login to the application
   Actors: Employee

   Scenario: Employee can log in
   Given that the employee is not logged in
   And the right initials is "abcd"
   When the employee enters "abcd"
   Then the employee is logged in
   And the employee is redirected to the application

#    Scenario: Employee cannot log in
#    Given that the employee is not logged in
#    And the right initials is "abcd"
#    When the employee enters "xyz"
#    Then the employee is not logged in
#    And the employee is shown an error message
