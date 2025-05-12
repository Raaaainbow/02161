//mob programming Sebastian, Caroline, Sophia, Katarina

package dtu.example.backend;

import java.time.LocalDate;

public class TimeRegistration {
    private LocalDate date;
    private double hours;
    private String initials;

    public TimeRegistration(double hours, String initials, LocalDate date) {
    double positiveHours = Math.abs(hours);
    double roundedHours = Math.floor(positiveHours * 2.0 + 0.5) / 2.0;
    this.hours = roundedHours;
    this.initials = initials;
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
