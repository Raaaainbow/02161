Feature: Register time
    As an employee
    I want 
    So that

    Scenario: Create a new time registration
        Given there exists a time registration on "2024-04-05T14:00" and shift ends "2024-04-05T15:00"
        Then the shift start is "2024-04-05T14:00"
        And the shift end is "2024-04-05T15:00"
        And the date should be "2024-04-05"

    Scenario: Update shift start time
        Given there exists a time registration with shift start "2024-04-05T14:00" 
        When the shift start is updated to "2024-04-05T12:00"
        Then the shift start should be "2024-04-05T12:00"

    Scenario: Update shift end time
        Given there exists a time registration with shift end "2024-04-05T15:00"
        When the shift end is changed to "2024-04-05T16:00"
        Then the shift end is updated to "2024-04-05T16:00"

    Scenario: Mark time registrations as deleted
        Given there exists a time registration with shift start "2024-04-05T14:00" and shift end "2024-04-05T15:00"
        When the time registration is deleted
        Then the time registration should be marked as deleted
