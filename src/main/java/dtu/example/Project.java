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
	private static List<String> projectLeaderListProject = new ArrayList<>();
	private boolean projectLeaderInProject = false;

	public Project(String title, String projectNumber) {
		this.title = title;
		this.projectNumber = projectNumber;
	}

	// Sebastian
	public Project(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	// Sebastian
	public void addTask(Task task) {
		tasks.add(task);
	}

	// Sebastian
	public boolean taskExists(Task task) {
		return tasks.contains(task);
	}
	
	public List<Task> getTasks() {
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
	}


	public void setStartWeek(int startWeek) {
		if (startWeek > 0 && startWeek < 52) {
			this.startWeek = startWeek;
		}
	}

	public int getEndWeek() {
		return (endWeek > 0 && endWeek < 52) ? endWeek : 0;
	}

	public void setEndWeek(int endWeek) {
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
}
