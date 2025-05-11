// mob programming Sophia, Caroline, Sebastian, Katarina

package dtu.example;

import java.util.ArrayList;
import java.util.List;
import dtu.example.Database;

public class Project {
	private String title;
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
		if ((startWeek <= 0 || startWeek > 52) && (endWeek <= 0 || endWeek > 52)) {
			throw new IllegalArgumentException("Start week and end week is not valid");
		} else if (startWeek <= 0 || startWeek > 52) {
			throw new IllegalArgumentException("Start week is not valid");
		} else if (endWeek <= 0 || endWeek > 52) {
			throw new IllegalArgumentException("End week is not valid");
		} else {
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

	public void makeProjectLeader(String initials) {
		if (!projectLeaderInProject()){
			setProjectLead(initials);
		} else {
			throw new IllegalArgumentException(getProjectLead() + "is the project leader of this project");
		}
	}

	public boolean projectLeaderInProject() {
		if (getProjectLead() == null) {
			return false;
		}
        return true;
    }

	public String getProjectNumber() {
		return projectNumber;
	}

	public List<Task> getTaskList() {
		return tasks;
	}

	public Task getTaskByTitle(String title) {
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				return task;
			}
		}
    	return null;
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
}
