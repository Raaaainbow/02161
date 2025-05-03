package dtu.example;

import java.util.ArrayList;

public class Task {
  private String description;
  private Employee assignedEmployee;
  private int budgetedHours;
  private int spentHours;
  private String title;
  private int hours;
  private int startWeek;
  private int endWeek;

  public Task(String title, int startWeek, int endWeek) {
    this.title = title;
    this.startWeek = startWeek;
    this.endWeek = endWeek;
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

  public void setEstimatedTime(int hours2) {
    
  }

}
