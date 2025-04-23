package dtu.example;

public class Project {
    private String title;
    private String Id;
    private int startWeek;
    private int endWeek;
	private String projectLead;

    // setters & getters

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
}
