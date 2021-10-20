package uk.ac.ncl.assessment.tests.factory.supervisor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;

public class SupervisorTest {
    Supervisor supervisor;
    @Before
    public void setUp() {
        supervisor = Supervisor.getInstance("John", "Doe", "john@ncl.ac.uk");
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
        assertEquals("john@ncl.ac.uk", supervisor.getEmail());
    }

    @Test
    public void toStringTest() {
        assertEquals("Name: John Doe, Email: john@ncl.ac.uk", supervisor.toString());
    }

    @Test
    public void equalsTest() {
        Supervisor anotherSupervisor = Supervisor.getInstance("Jane", "Doe", "jane@ncl.ac.uk");
        assertNotEquals(supervisor, anotherSupervisor);
        assertFalse(supervisor.equals(new Object()));
    }

    @Test
    public void testHashCode() {
        Supervisor anotherSupervisor = Supervisor.getInstance("Jane", "Doe", "jane@ncl.ac.uk");
        assertNotEquals(supervisor.hashCode(), anotherSupervisor.hashCode());
    }
}