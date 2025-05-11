# mob programming Caroline, Sophia, Sebastian, Katarina

Feature: Project Leader management
  Description: employee and project leader management
  Actor: employee


  Scenario: Promote an existing employee to project leader
    Given the database is initialised
    And the project "P-251" exists
    When an employee promotes employee "khf" to project leader in the project
    Then the employee "khf" is the project leader in the project

  Scenario: Failing to promote an employee to project leader in a project with an existing project leader
    Given the database is initialised
    And the project "P-251" exists
    And "cp" is project leader in the project 
    When an employee tries to promote employee "sass" to project leader in the project
    Then the employee "sass" is not promoted to project leader
    

    #
    #  Scenario: Remove project leader role
    #    Given the database is initialised
    #   Given employee with initials "SES" is a project leader
    #    When I remove the project leader role from employee with initials "SES"
    #    Then employee with initials "SES" should no longer be a project leader
