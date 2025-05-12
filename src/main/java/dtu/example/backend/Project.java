package dtu.example.backend;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String title;
	private String projectLead;
	public String projectNumber;
	private List<Task> tasks = new ArrayList<Task>();
	// Sebastian
	public Project(String title, String projectNumber) {
		setTitle(title);
		setProjectNumber(projectNumber);
	}
	// Sophia
	public Project(String projectNumber) {
		setProjectNumber(projectNumber);
	}
	// Caroline
    public Task createTask(String title, double hours, int startWeek, int endWeek, String projectNumber) {
        if ((startWeek <= 0 || startWeek > 52) && (endWeek <= 0 || endWeek > 52)) {
            throw new IllegalArgumentException("Start week and end week is not valid");
        } else if (startWeek <= 0 || startWeek > 52) {
            throw new IllegalArgumentException("Start week is not valid");
        } else if (endWeek <= 0 || endWeek > 52) {
            throw new IllegalArgumentException("End week is not valid");
        } else {
            Task task = new Task(title, hours, startWeek, endWeek, projectNumber); 
            tasks.add(task);
            return task;
        } 
    }
	// Katarina
	public boolean taskExists(String title) {
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
	// Sebastian
	public void makeProjectLeader(String initials) {
		setProjectLead(initials);
	}
	// Sophia
	public boolean projectLeaderInProject() {
		if (getProjectLead() == null) {
			return false;
		}
		return true;
	}
	// Caroline
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	// Katarina
	public String getProjectNumber() {
		return projectNumber;
	}
	// Sebastian
	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}
	// Sophia
	public String getProjectLead() {
		return projectLead;
	}
	// Caroline
	public void setTitle(String title) {
		this.title = title;
	}
	// Katarina
	public String getTitle() {
		return title;
	}
	// Sebastian
	public Task getTaskByTitle(String title) {
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				return task;
			}
		}
		return null;
	}
	// Sophia
	public List<Task> getTasks() {
		return tasks;
	}
	// Caroline
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Project Number: ").append(projectNumber).append("\n");
        output.append("Title: ").append(title != null ? title : "Untitled").append("\n");
        output.append("Project Leader: ").append(projectLead != null ? projectLead : "Not assigned").append("\n");
        output.append("Tasks: ").append(tasks.size()).append("\n");
        return output.toString();
    }
}
