package dtu.example;

public class Task {
  private String description;
  private Employee assignedEmployee;
  private boolean projectLeaderAssigned;
  private boolean isProjectLeader;
  private int budgetedHours;
  private int spentHours;
  private String title;
  private int hours;
  private int startWeek;
  private int endWeek;

  public Task(String title) {
    this.title = title;
  }

  public void setStartWeek(int startWeek) {
    if (startWeek > 0 && startWeek < 52) {
      this.startWeek = startWeek;
    }
  }

  public int getStartWeek() {
    return (startWeek > 0 && startWeek < 52) ? startWeek : 0;
  }

  public void setEndWeek(int endWeek) {
    if (endWeek > 0 && endWeek < 52) {
      this.endWeek = endWeek;
    }
  }

  public int getEndWeek() {
    return (endWeek > 0 && endWeek < 52) ? endWeek : 0;
  }

  public void setEstimatedTime(int hours) {
    this.hours = hours;
  }

  public String getTitle() {
    return title;
  }

  public void assignEmployee(Employee employee) {
    this.assignedEmployee = employee;
  }

  public Employee getAssignedEmployee() {
    return assignedEmployee;
  }

  public void add(Task task) {
    throw new UnsupportedOperationException("Unimplemented method 'add'");
  }

}
