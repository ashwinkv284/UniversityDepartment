package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentName;

import static org.junit.Assert.assertEquals;

public class StudentNameTest {
    StudentName name;
    @Before
    public void setUp() {
        name = new StudentName("John", "Doe");
    }

    @Test
    public void getFirstNameTest() {
        assertEquals("John", name.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertEquals("Doe", name.getLastName());
    }

    @Test
    public void toStringTest() {
        assertEquals("John Doe", name.toString());
    }
}