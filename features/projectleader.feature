Feature: Project leader 
    Description: Adding a task to the project if a project leader exists
    Acotr: Project leader 

    Scenario: A project leader wants to add a task to the project
        Given a project with a project leader exists 
        And the project leader is loggen in
        When the project leader adds a task to the project
        Then a task is created in the project 
