package dtu.example;

public class Project {
    private String title;
    private String Id;
    private int startWeek;
    private int endWeek;
	private String projectLead;
    public String projectNumber;
	private boolean taskExists;
    private Project createdProject;
    private String givenProjectName;
	private int counter = 1;

	public Project(Task task) {
		this.projectNumber = "P-" + counter++;
	}

    public Project(String title) {
		this.title = title;
		this.projectNumber = "P-" + counter++;
	}

	public boolean taskExists() {
        return taskExists;
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
		return (startWeek > 0 && startWeek < 52)? startWeek: 0;
	}
    
	public void setStartWeek(int startWeek) {
        if (startWeek > 0 && startWeek < 52) {
            this.startWeek = startWeek;   
        }
	}

	public int getEndWeek() {
		return (endWeek > 0 && endWeek < 52)? endWeek: 0;
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
