package dtu.example;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String title;
	private String Id;
	private int startWeek;
	private int endWeek;
	private String title;
	private String Id;
	private int startWeek;
	private int endWeek;
	private String projectLead;
	public String projectNumber;
	private List<Task> tasks = new ArrayList<Task>();
	private Project createdProject;
	private String givenProjectName;
	private int counter = 1;
	private static List<String> projectLeaderListProject = new ArrayList<>();
	private boolean projectLeaderExistsinproject = false;

	public Project(Task task) {
		this.projectNumber = "P-" + counter++;
		tasks.add(task);
		tasks.add(task);
	}

	public Project(String title) {
	public Project(String title) {
		this.title = title;
		this.projectNumber = "P-" + counter++;
	}

	// Sebastian
	public Project() {
		Id = "" + (counter + 1);
	// Sebastian
	public Project() {
		Id = "" + (counter + 1);
	}

	// Sebastian
	public void addTask(Task task) {
		tasks.add(task);
	}

	// Sebastian
	public boolean taskExists(Task task) {
		return tasks.contains(task);
	}
		return tasks.contains(task);
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}


	public int getStartWeek() {
		return (startWeek > 0 && startWeek < 52) ? startWeek : 0;
		return (startWeek > 0 && startWeek < 52) ? startWeek : 0;
	}


	public void setStartWeek(int startWeek) {
		if (startWeek > 0 && startWeek < 52) {
			this.startWeek = startWeek;
		}
		if (startWeek > 0 && startWeek < 52) {
			this.startWeek = startWeek;
		}
	}

	public int getEndWeek() {
		return (endWeek > 0 && endWeek < 52) ? endWeek : 0;
		return (endWeek > 0 && endWeek < 52) ? endWeek : 0;
	}

	public void setEndWeek(int endWeek) {
		if (endWeek > 0 && endWeek < 52) {
			this.endWeek = endWeek;
		}
		if (endWeek > 0 && endWeek < 52) {
			this.endWeek = endWeek;
		}
	}

	public String getProjectLead() {
		return projectLead;
	}


	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public boolean addTaskAsEmployee(Employee employee, Task task) {
		if (!projectLeaderExistsinproject) {
			task.add(task);
			return true;
		} else {
			return false;
		}
	}

}
