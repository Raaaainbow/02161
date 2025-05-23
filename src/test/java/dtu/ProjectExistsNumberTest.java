// Katarina

package dtu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import dtu.example.backend.Database;
import dtu.example.backend.Project;

public class ProjectExistsNumberTest {
    // Katarina
    @Test
    public void testProjectExistsNumber_MatchingProjectNumber() {
        Database database = new Database();
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber();
        assertEquals("P-255", projectNumber);
        assertTrue(database.projectExistsNumber("P-255"));
    }
    // Katarina
    @Test
    public void testProjectExistsNumber_NoMatch() {
        Database database = new Database();
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber();
        assertNotEquals("P-001", projectNumber);
        assertFalse(database.projectExistsNumber("P-001"));
    }
    // Katarina
    @Test
    public void testProjectExistsNumber_NullInput() {
        Database database = new Database();
        database.createProject();
        List<Project> projects = database.getProjects();
        String projectNumber = projects.getLast().getProjectNumber();
        assertNotEquals(null, projectNumber);
        assertFalse(database.projectExistsNumber(null));
    }
}
