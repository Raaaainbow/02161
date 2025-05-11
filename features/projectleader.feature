Feature: Project Leader management
  As an administrator
  I want to manage project leaders who are a type of employee
  So that they can be assigned leadership roles in projects

  Background:
    Given the following employees exist: "EET" "HPH" "SES"
    And the database is initialised

  Scenario: Promote an existing employee to project leader
    Given the project "P-255" exists
    When I promote employee with initials "EET" to project leader on "P-255"
    Then the employee with initials "EET" should be a project leader on "P-255"

  Scenario: Create a new project leader
    Given the project "P-255" exist
    And the project "P-255" does not have a project leader
    When "EET" assigns them self as project leader
    Then a project leader with initials "EET" should exist
    And they should be assigned to the "P-255" project

    #  Scenario: View all project leaders
    #    Given "EET" is project leader in "P-255" 
    #    And "HPH" is project leader in "P-256"
    #    When I view the list of project leaders
    #    Then The list will contain "EET" with "P-255"
    #    And The list will contain "HPH" with "P-256"
    #
    #  Scenario: Remove project leader role
    #    Given employee with initials "SES" is a project leader
    #    When I remove the project leader role from employee with initials "SES"
    #    Then employee with initials "SES" should no longer be a project leader
