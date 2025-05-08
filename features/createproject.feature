# mob programming Sebastian, Caroline, Sophia, Katarina

Feature: Create Project 
  Description: Employee creates a project
  Actor: Employee

 Scenario: Employee creates a project without a name  
   Given there is a task  
   When the employee creates a project  
   And the employee does not provide a project name  
   Then the system assigns a project number to the new project  

 Scenario: Employee creates a project with a name 
   Given there is a task  
   When the employee creates a project with the name "ByggeProjekt"
   Then the system assigns a project number to the project  
   And the project is saved with the name "ByggeProjekt"        
