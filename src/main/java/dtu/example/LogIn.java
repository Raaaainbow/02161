package dtu.example;
// mob programming Caroline, Katarina
public class LogIn {
    private boolean loggedIn = false;
    private String correctInitials;
    private String enteredInitials;
    
    public void loggingIn(Employee employee, String enteredInitials) {
        correctInitials = employee.getInitials();
        this.enteredInitials = enteredInitials;
        if (loggedIn == false) {
            if (correctInitials.equals(enteredInitials)) {
                loggedIn = true;
                System.out.println("You are now logged in!");
            }
            else {
                loggedIn = false;
                System.out.println("Wrong initials! Try again.");
            }
        }
        else {
            System.out.println("You are already logged in!");
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

