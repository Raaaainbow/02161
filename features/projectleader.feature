# mob programming Caroline, Sophia, Sebastian, Katarina

Feature: Project Leader management
  Description: employee and project leader management
  Actor: employee


  Scenario: Promote an existing employee to project leader
    Given the database is initialised
    And the project "P-251" exists
    When an employee promotes employee "khf" to project leader in the project
    Then the employee "khf" is the project leader in the project
    
  Scenario: Replace project leader role
    Given the database is initialised
    And employee with initials "sass" is a project leader in the project "P-251"
    When an employee replaces project leader "sass" with employee "cp" in the project
    Then the employee "cp" is the project leader in the project
    Then employee with initials "sass" should no longer be a project leader in project "P-251"
