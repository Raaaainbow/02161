// mob programming Sophia, Katarina, Caroline

package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private List<String> projectLeaderListProject = new ArrayList<>();

    public Employee(String initials) {
        setInitials(initials);
        
    }

    public String changeInitials(String newInitials) {
        setInitials(newInitials);
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials;
    }

}