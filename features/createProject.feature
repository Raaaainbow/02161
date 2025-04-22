Feature: Create project
    Description: Creating project and activities
    Actor: Employee

    Scenario: Employee can create a project without a name
        Given that there is a task 
        When an employee creates a project
        And the employee does not give the project a name
        Then a project is created with a project number

    Scenario: Employee can create a project with a name
        Given that there is a task 
        When an employee creates a project with a name
        Then a project is created with a project number and a name


 Feature: Create Project  
  As an employee,  
  I want to create a project with or without a name,  
  So that I can manage work effectively.  

  Scenario: Employee creates a project without a name  
    Given there is a task  
    When the employee creates a project  
    And the employee does not provide a project name  
    Then the system assigns a project number to the new project  

  Scenario: Employee creates a project with a name  
    Given there is a task  
    When the employee creates a project with a name  
    Then the system assigns a project number to the project  
    And the project is saved with the given name             
