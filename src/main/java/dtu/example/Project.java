// mob programming Sophia, Caroline, Sebastian, Katarina

package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String title;
	private String projectLead;
	public String projectNumber;
	private List<Task> tasks = new ArrayList<Task>();

	public Project(String title, String projectNumber) {
		setTitle(title);
		setProjectNumber(projectNumber);
	}

	public Project(String projectNumber) {
		setProjectNumber(projectNumber);
	}

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

	public boolean taskExists(String title) {
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}

	public void makeProjectLeader(String initials) {
		if (!projectLeaderInProject()) {
			setProjectLead(initials);
		} else {
			throw new IllegalArgumentException(getProjectLead() + "is the project leader of this project");
		}
	}

	public boolean projectLeaderInProject() {
		assert true;

		boolean result = getProjectLead() != null;

		if (getProjectLead() == null) {
			return false;
		}
		assert result == (getProjectLead() != null) : "Post-condition failed: project leader should be null";
		return result;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
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

	public Task getTaskByTitle(String title) {
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				return task;
			}
		}
		return null;
	}

	public List<Task> getTasks() {
		return tasks;
	}
}
