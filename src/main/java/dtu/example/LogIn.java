package dtu.example;

public class LogIn {
    private boolean loggedIn = false;
    private String correctInitials = "abcd";
    private String enteredInitials;

    public void loggingIn(String enteredInitials) {
        this.enteredInitials = enteredInitials;
        if (loggedIn = false) {
            if (enteredInitials.equals(correctInitials)) {
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
    
    public void setCorrectInitials(String initials) {
        this.correctInitials = initials;
    }

    public String getCorrectInitials() {
        return correctInitials;
    }

    public String getEnteredInitials() {
        return enteredInitials;
    }

}

