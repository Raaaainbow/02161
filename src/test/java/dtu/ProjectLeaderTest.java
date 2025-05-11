package dtu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import dtu.example.Database;
import dtu.example.Project;

public class ProjectLeaderTest {
    @Test
    public void testProjectLeaderInProject_ThereIsAProjectLeader() {
        Database database = new Database();
        database.createEmployee("sass");
        database.createProject();
        List<Project> projects = database.getProjects(); 
        String projectNumber = projects.getLast().getProjectNumber(); 
        Project project = database.getProjectByNumber(projectNumber); 
        project.makeProjectLeader("sass");
        assertTrue(project.projectLeaderInProject());
    }

    @Test
    public void testProjectLeaderExists_ThereIsNoProjectLeaderInProject() {
        Database database = new Database();
        database.createEmployee("sass");
        database.createProject();
        List<Project> projects = database.getProjects(); 
        String projectNumber = projects.getLast().getProjectNumber(); 
        Project project = database.getProjectByNumber(projectNumber); 
        assertFalse(project.projectLeaderInProject());
    }
}
