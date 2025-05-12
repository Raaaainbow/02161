package dtu.example.backend;

public class LogIn {
    private boolean loggedIn = false;
    // Katarina
    public boolean loggingIn(Employee employee, String enteredInitials) {
        if (employee == null) {
            System.out.println("Employee does not exist!");
            return false;
        }
        
        String correctInitials = employee.getInitials();
        
        if (correctInitials.equals(enteredInitials)) {
            System.out.println("You are now logged in!");
            this.loggedIn = true;
            return true;
        } else {
            System.out.println("Wrong initials! Try again.");
            this.loggedIn = false;
            return false;
        }
    }
    // Caroline
    public boolean isLoggedIn() {
        return loggedIn;
    }
}

