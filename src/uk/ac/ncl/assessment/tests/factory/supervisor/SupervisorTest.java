package uk.ac.ncl.assessment.tests.factory.supervisor;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;

import java.util.Random;

import static org.junit.Assert.*;

public class SupervisorTest {
    Supervisor supervisor;
    int code;
    @Before
    public void setUp() throws Exception {
        Random rd = new Random();
        code = rd.nextInt(10000);
        supervisor = Supervisor.getInstance("John", "Doe", "john" + String.valueOf(code) + "@ncl.ac.uk");
    }

    @Test
    public void getInstanceTest() {
        assertNotNull(supervisor);
    }

    @Test
    public void getFirstNameTest() {
        assertEquals("John", supervisor.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertEquals("Doe", supervisor.getLastName());
    }

    @Test
    public void getEmailTest() {
        assertEquals("john" + code + "@ncl.ac.uk", supervisor.getEmail());
    }

    @Test
    public void toStringTest() {
        assertEquals("Name: John Doe, Email: john" + code + "@ncl.ac.uk", supervisor.toString());
    }

    @Test
    public void equalsTest() throws Exception {
        Supervisor anotherSupervisor = Supervisor.getInstance("Jane", "Doe", "jane@ncl.ac.uk");
        assertNotEquals(supervisor, anotherSupervisor);
        assertFalse(supervisor.equals(new Object()));
    }

    @Test
    public void testHashCode() throws Exception {
        Supervisor anotherSupervisor = Supervisor.getInstance("Jane", "Doe", "jane1@ncl.ac.uk");
        assertNotEquals(supervisor.hashCode(), anotherSupervisor.hashCode());
    }

    @Test
    public void supervisorAlreadyExistsTest() {
        try {
            Supervisor.getInstance("John", "Doe", "john" + String.valueOf(code) + "@ncl.ac.uk");
        } catch (Exception e) {
            assertEquals("Supervisor already exists", e.getMessage());
        }
    }
}