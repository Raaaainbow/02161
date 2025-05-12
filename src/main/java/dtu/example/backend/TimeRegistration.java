//mob programming Sebastian, Caroline, Sophia, Katarina

package dtu.example.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeRegistration {
    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;
    private LocalDate date;
    private boolean deleted;
    private double hours;
    private String initials;

    public TimeRegistration(double hours, String initials, LocalDate date) {
        double roundedHours= Math.round(hours * 2.0)/2.0;
        roundedHours = Math.abs(roundedHours);
        this.hours = roundedHours;
        this.initials = initials;
        this.date = date;
    }

    public void deleteTimeReg(){
        deleted = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate(){
        return date;
    }

    public double getHours() {
        return hours;
    }

    public String toString() {
       return String.format("%s - %.1f hours (%s)", 
           date != null ? date.toString() : "No date", 
           hours, 
           initials);
    }
    
}
