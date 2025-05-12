// mob programming Sebastian, Sophia, Caroline, Katarina

package dtu.example;

import java.time.LocalDate;

public class Task {
  private Employee assignedEmployee;
  private double hours;
  private String title;
  private int startWeek;
  private int endWeek;
  private LocalDate startDate;
  private LocalDate endDate;
  private Project project;

  public Task(String title, double hours, int startWeek, int endWeek, String projectNumber) {
    this.title = title;
    setEstimatedTime(hours);
    setStartWeek(startWeek);
    setEndWeek(endWeek);
  }

  public Task(String title, double hours, int startWeek, int endWeek) {
    this.title = title;
    setEstimatedTime(hours);
    setStartWeek(startWeek);
    setEndWeek(endWeek);
  }

  public Task(LocalDate startDate, LocalDate endDate, String title) {
    setStartDate(startDate);
    setEndDate(endDate);
    this.title = title + startDate + " " + endDate;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public void setAssignedEmployee(Employee employee) {
    this.assignedEmployee = employee;
  }

  public Employee getAssignedEmployee() {
    return assignedEmployee;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public LocalDate getEndDate() {
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

  // Sebastian
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("Task: ").append(title).append("\n");
    output.append("  Duration: Week ").append(startWeek).append(" - ").append(endWeek);
    output.append(" (").append(hours).append(" hours)").append("\n");
    output.append("  Employee: ").append(assignedEmployee != null ? assignedEmployee.getInitials() : "Not assigned")
        .append("\n");
    output.append("  Status: Active");
    return output.toString();
  }

  public String toString2() {
    StringBuilder output = new StringBuilder();
    output.append("").append(title).append("\n");
    output.append("  Duration: ").append(startDate).append(" - ").append(endDate).append("\n");
    output.append("  Status: Approved");
    return output.toString();
  }

  // public void assignEmployee(Employee employee) {
  // this.assignedEmployee = employee;
  // }

  // public Employee getAssignedEmployee() {
  // return assignedEmployee;
  // }

  // public void add(Task task) {

  // }

  // public boolean taskExists() {
  // return taskExists;
  // }

}
