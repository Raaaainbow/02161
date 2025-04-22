package dtu.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeRegistration {
    private LocalDateTime ShiftStart;
    private LocalDateTime ShiftEnd;
    private LocalDate Date;
    private boolean deleted;

    public TimeRegistration(LocalDateTime ShiftStart, LocalDateTime ShiftEnd, LocalDate Date){
        this.ShiftStart = ShiftStart;
        this.ShiftEnd = ShiftEnd;
        this.Date = Date;
    }

    public void deleteTimeReg(){
        deleted = true;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setShiftStart(LocalDateTime ShiftStart){
        this.ShiftStart = ShiftStart;
    }

    public LocalDateTime getShiftStart(){
        return ShiftStart;
    }

    public void setShiftEnd(LocalDateTime ShiftEnd){
        this.ShiftEnd = ShiftEnd;
    }

    public LocalDateTime getShiftEnd(){
        return ShiftEnd;
    }

    public void setLocalDate(LocalDate Date){
        this.Date = Date;
    }

    public LocalDate getLocalDate(){
        return Date;
    }
    
}
