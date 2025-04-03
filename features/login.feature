Feature: Employee login
    
        Scenario: Employee can log in
            Given that the employee is not logged in
            And the right initials is "abcd"
            When employee writes initials "abcd"
            Then the employee is logged in
      
        Scenario: Employee writes wrong initials
            Given that the employee is not logged in
            And the right initials is "abcd"
            When the employee writes initials "aabc"
            Then the employee is not logged in
