// mob programming Sebastian, Sophia, Caroline, Katarina

package dtu.example.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
  private Employee assignedEmployee;
  private double estimatedHours;
  private double spentHours;
  private String title;
  private int startWeek;
  private int endWeek;
  private LocalDate startDate;
  private LocalDate endDate;
  private List<TimeRegistration> TimeRegistrations = new ArrayList<>();
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
    this.estimatedHours = hours;
  }

  public String getTitle() {
    return title;
  }

  public void addTimeRegistration(TimeRegistration time) {
      TimeRegistrations.add(time);
  }

  public List<TimeRegistration> getTimeRegistrations() {
      return TimeRegistrations;
  }

  // Sebastian
    public String toString() {
       StringBuilder output = new StringBuilder();
       output.append("Task: ").append(title).append("\n");
       output.append("  Duration: Week ").append(startWeek).append(" - ").append(endWeek);
       output.append(" (").append(estimatedHours).append(" hours)").append("\n");
       output.append("  Employee: ").append(assignedEmployee != null ? assignedEmployee.getInitials() : "Not assigned")
           .append("\n");
       output.append("  Status: Active").append("\n");
       output.append("  Time Registrations: ");
       if (TimeRegistrations.isEmpty()) {
           output.append("None");
       } else {
           output.append("\n");
           spentHours = 0;
           for (TimeRegistration tr : TimeRegistrations) {
               spentHours += tr.getHours();
               output.append("    ").append(tr.toString()).append("\n");
           }
           output.append("  Total hours spent: ").append(spentHours);
       }
       return output.toString();
    }

  public String toString2() {
    StringBuilder output = new StringBuilder();
    output.append("").append(title).append("\n");
    output.append("  Duration: ").append(startDate).append(" - ").append(endDate).append("\n");
    output.append("  Status: Approved");
    return output.toString();
  }
}
