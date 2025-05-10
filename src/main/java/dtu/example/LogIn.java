package dtu.example;
// mob programming Caroline, Katarina
public class LogIn {
    private boolean loggedIn = false;
    private String correctInitials;
    private String enteredInitials;
    
    public boolean loggingIn(Employee employee, String enteredInitials) {
        if (employee == null) {
            System.out.println("Employee does not exist!");
            return false;
        }
        
        String correctInitials = employee.getInitials();
        
        if (correctInitials.equals(enteredInitials)) {
            System.out.println("You are now logged in!");
            return true;
        } else {
            System.out.println("Wrong initials! Try again.");
            return false;
        }
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    // public void setCorrectInitials(String initials) {
    //     this.correctInitials = initials;
    // }
    
    // public String getCorrectInitials() {
    //     return correctInitials;
    // }

    // public String getEnteredInitials() {
    //     return enteredInitials;
    // }

}

