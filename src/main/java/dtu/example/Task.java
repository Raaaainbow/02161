// mob programming Sebastian, Sophia, Caroline, Katarina

package dtu.example;

import java.time.LocalDate;

public class Task {
  private Employee assignedEmployee;
  private int budgetedHours;
  private int spentHours;
  private double hours;
  private String title;
  private int startWeek;
  private int endWeek;
  private LocalDate startDate;
  private LocalDate endDate;
  private boolean taskExists = false;

  public Task(String title, double hours, int startWeek, int endWeek, String projectNumber) {
    this.title = title;
    setEstimatedTime(hours);
    setStartWeek(startWeek);
    setEndWeek(endWeek);
    this.taskExists = true;
  }

  public Task(LocalDate startDate, LocalDate endDate, String title) {
    setStartDate(startDate);
    setEndDate(endDate);
    this.title = title + startDate + " " + endDate;
  }

  public void setStartDate(LocalDate startDate){
    this.startDate = startDate;
  }

  public LocalDate getStartDate(){
    return startDate;
  }

  public void setEndDate(LocalDate endDate){
    this.endDate = endDate;
  }

  public LocalDate getEndDate(){
    return endDate;
  }

  public void setStartWeek(int startWeek) {
    this.startWeek = startWeek;
    
  }

  public int getStartWeek() {
    return startWeek;
  }

  public void setEndWeek(int endWeek) {
    this.endWeek = endWeek;
  }

  public int getEndWeek() {
    return endWeek;
  }

  public void setEstimatedTime(double hours) {
    this.hours = hours;
  }

  public String getTitle() {
    return title;
  }

  // public void assignEmployee(Employee employee) {
  //   this.assignedEmployee = employee;
  // }

  // public Employee getAssignedEmployee() {
  //   return assignedEmployee;
  // }

  // public void add(Task task) {

  // }

  // public boolean taskExists() {
  //   return taskExists;
  // }

}
