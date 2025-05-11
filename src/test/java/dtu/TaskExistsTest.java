// Caroline

package dtu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import dtu.example.Database;
import dtu.example.Project;

public class TaskExistsTest {
    // Caroline
    @Test
    public void testTaskExists_MatchingTaskTitle() {
        Database database = new Database();
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber(); 
        Project project = database.getProjectByNumber(projectNumber); 
        project.createTask("Coding", 20, 10, 12, projectNumber);
        assertTrue(project.taskExists("Coding"));
    }
    // Caroline
    @Test
    public void testTaskExists_NoMatch() {
        Database database = new Database();
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber(); 
        Project project = database.getProjectByNumber(projectNumber); 
        project.createTask("Coding", 20, 10, 12, projectNumber);
        assertFalse(project.taskExists("Not coding"));
    }
    // Caroline
    @Test
    public void testTasktExists_NullInput() {
        Database database = new Database();
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber(); 
        Project project = database.getProjectByNumber(projectNumber); 
        project.createTask("Coding", 20, 10, 12, projectNumber);
        assertFalse(project.taskExists(null));
    }   
}
