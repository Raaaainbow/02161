
Feature: Time Registration Management
  As an employee
  I want to register my working hours
  So that my time is accurately tracked for payroll and reporting
  # Sebastian
  Background:
    Given today's date is "2025-02-15"
  # Sebastian
  Scenario: Register hours with manual input
    Given I am an employee with initials "SK"
    When I register 8.5 hours worked on "2025-02-15"
    Then my time registration should show 8.5 hours
    And the date should be "2025-02-15"
    And my initials should be "SK"
  # Sebastian
  Scenario: Hours are rounded using standard rounding to nearest half hour
    Given I am an employee with initials "CJ"
    When I register 7.3 hours worked on "2025-02-15"
    Then my time registration should show 7.5 hours
  # Sebastian
  Scenario: Negative hours are converted to positive
    Given I am an employee with initials "SP"
    When I register -6.5 hours worked on "2025-02-15"
    Then my time registration should show 6.5 hours
  # Sebastian
  Scenario: Display time registration
    Given I have a time registration with initials "CJ" for 7.5 hours on "2025-02-15"
    And there are no shift times
    Then the display should show "2025-02-15 - 7,5 hours (CJ)"
  # Sebastian
  Scenario Outline: Round different hour values using standard rounding
    Given I am an employee with initials "SP"
    When I register <input_hours> hours worked on "2025-02-15"
    Then my time registration should show <expected_hours> hours

    Examples:
      | input_hours | expected_hours |
      | 8.1         | 8.0            |
      | 8.25        | 8.5            |
      | 8.4         | 8.5            |
      | 8.6         | 8.5            |
      | 8.75        | 9.0            |
      | 8.9         | 9.0            |
