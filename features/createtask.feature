# mob programming Sophia, Katarina, Sebastian

Feature: Create activity
    Description: Creating an activity
    Actor: Project leader
        
    Scenario: Project leader creates an activity with estimated time usage 
        Given that there is a project 
        When the project leader creates an activity 
        And assigns 50 hours over 2 weeks
        Then an activity is created in the given project
        And the activity has a starting week and ending week

    Scenario: Project leader creates an activity without estimated time usage 
        Given that there is a project 
        When the project leader creates an activity 
        Then an activity is created in the given project
        And the activity has no starting week and ending week

    Scenario: Employee tries to create a new activity
        Given that there is a project
        When the employee creates an activity
        And there is a project leader
        Then an error message occurs