// mob programming Sophia, Katarina, Caroline

package dtu.example.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String initials;
    private String title;
    private List<Task> tasks = new ArrayList<Task>();
    private List<Task> vacationList = new ArrayList<Task>();
    private List<Task> sickLeaveList = new ArrayList<Task>();
    private List<Task> courseList = new ArrayList<Task>();

    public Employee(String initials) {
        setInitials(initials);
    }
    
    public String changeInitials(String newInitials) {
        setInitials(newInitials);
        return initials;
    }

    public void createVacation(LocalDate startDate, LocalDate endDate) {
        Task vacation = new Task(startDate, endDate, "Vacation ");
        this.title = vacation.getTitle();
        vacationList.add(vacation);
    }

    public void createSickLeave(LocalDate startDate, LocalDate endDate) {
        Task sickLeave = new Task(startDate, endDate, "Sick Leave ");
        this.title = sickLeave.getTitle();
        sickLeaveList.add(sickLeave);
    }

    public void createCourse(LocalDate startDate, LocalDate endDate) {
        Task course = new Task(startDate, endDate, "Course ");
        this.title = course.getTitle();
        courseList.add(course);
    }

	public void createTask(String title, double hours, int startWeek, int endWeek) {
		if ((startWeek <= 0 || startWeek > 52) && (endWeek <= 0 || endWeek > 52)) {
			throw new IllegalArgumentException("Start week and end week is not valid");
		} else if (startWeek <= 0 || startWeek > 52) {
			throw new IllegalArgumentException("Start week is not valid");
		} else if (endWeek <= 0 || endWeek > 52) {
			throw new IllegalArgumentException("End week is not valid");
		} else {
			Task task = new Task(title, hours, startWeek, endWeek); 
        	tasks.add(task);
		} 
    }
    
    public List<Task> getVacationList() {
        return vacationList;
    }

    public List<Task> getSickLeaveList() {
        return sickLeaveList;
    }
    
    public List<Task> getCourseList() {
        return courseList;
    }
    
    public Task getVacation(String title){
        for (Task vacation : vacationList) {
            if (vacation.getTitle().equals(title)) {
                return vacation;
            }
        }
        return null;
    }
    
    public Task getSickLeave(String title){
        for (Task sickLeave : sickLeaveList) {
            if (sickLeave.getTitle().equals(title)) {
                return sickLeave;
            }
        }
        return null;
    }

    public Task getCourse(String title){
        for (Task course : courseList) {
            if (course.getTitle().equals(title)) {
                return course;
            }
        }
        return null;
    }
    
    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    public String getInitials() {
        return initials;
    }
    
    public String getTitle() {
        return title;
    }

    public List<Task> getAssignedTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
