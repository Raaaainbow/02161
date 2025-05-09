# Sebastian

Feature: Project Management in the Database

    Actor: Employee & ProjectManager

	Scenario: Creating a new project
		Given the database is initialized
		When I create a project with ID "P123", start week 10, and end week 20
		Then the project "P123" should be stored in the database
		And its start week should be 10
		And its end week should be 20

    Scenario: Updating an existing project
        Given the database is initialized
        Given a project with name "P123" exists in the database
        When I update the project "P123" to end in week 25
        Then the project "P123" should have end week 25
    
    Scenario: Creating a new user
        Given the database is initialized
        When I create a new user with initials "U001"
        Then the user "U001" should be stored in the database
    
    Scenario: Creating a project without any parameters
        Given the database is initialized
        When I create a new project without any parameters
        Then the project is created with a generated Id

    Scenario: Getting a list of all employees
        Given the database is initialized
        When I request a list of all employees
        Then I get a list of all employees
