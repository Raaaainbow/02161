//mob programming Sebastian, Caroline, Sophia, Katarina

package dtu.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeRegistration {
    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;
    private LocalDate date;
    private boolean deleted;

    public TimeRegistration(LocalDateTime shiftStart, LocalDateTime shiftEnd, LocalDate date){
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        setDate(date);
    }

    public void deleteTimeReg(){
        deleted = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setShiftStart(LocalDateTime shiftStart){
        this.shiftStart = shiftStart;
    }

    public LocalDateTime getShiftStart(){
        return shiftStart;
    }

    public void setShiftEnd(LocalDateTime shiftEnd){
        this.shiftEnd = shiftEnd;
    }

    public LocalDateTime getShiftEnd(){
        return shiftEnd;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate(){
        return date;
    }
    
}
