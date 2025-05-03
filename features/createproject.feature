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
