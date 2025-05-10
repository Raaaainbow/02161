package dtu.example;

import java.util.ArrayList;
import java.util.List;
import dtu.example.Database;

public class Project {
	private String title;
	private String Id;
	private int startWeek;
	private int endWeek;
	private String projectLead;
	public String projectNumber;
	private List<Task> tasks = new ArrayList<Task>();
	private Project createdProject;
	private String givenProjectName;
	private List<String> projectLeaderListProject = new ArrayList<>();
	private boolean projectLeaderInProject = false;
	private Task task;

	public Project(String title, String projectNumber) {
		this.title = title;
		this.projectNumber = projectNumber;
	}

	public Project(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public void createTask(String title, int hours, int startWeek, int endWeek, String projectNumber) {
		if (startWeek <= 0 || startWeek > 52 || endWeek <= 0 || endWeek > 52) {
			throw new IllegalArgumentException("Start week or end week is not valid");
		} else {
			setTitle(title);
			setStartWeek(startWeek);
			setEndWeek(endWeek);
			Task task = new Task(title, hours, startWeek, endWeek, projectNumber); 
        	tasks.add(task);
        	this.task = task;
		} 
    }

	public boolean taskExists(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

	public boolean taskExists(Task task) {
		return tasks.contains(task);
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public Task getTask() {
        return task;
    }

	public boolean projectLeaderInProject() {
        return !projectLeaderListProject.isEmpty();
    }

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}

	public String getProjectLead() {
		return projectLead;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setStartWeek(int startWeek) {
		if (startWeek > 0 && startWeek <= 52) {
			this.startWeek = startWeek;
		}
	}

	public int getStartWeek() {
		return startWeek;
	}

	public void setEndWeek(int endWeek) {
		if (endWeek > 0 && endWeek <= 52) {
			this.endWeek = endWeek;
		}
	}

	public int getEndWeek() {
		return endWeek;
	}
}
