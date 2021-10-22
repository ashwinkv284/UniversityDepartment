package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;

import static org.junit.Assert.*;

public class StudentIdTest {
    StudentId studentId;
    StudentId nullStudentId;
    @Before
    public void setUp() throws Exception {
        studentId = StudentId.getInstance();
    }

    @Test
    public void getInstanceTest() {
        assertNotNull(studentId);
        assertNull(nullStudentId);
    }

    @Test
    public void toStringTest() {
        assertNotNull(studentId.toString());
    }

    @Test
    public void equalsTest() throws Exception {
        StudentId sId = StudentId.getInstance();
        assertNotEquals(studentId, sId);
    }

    @Test
    public void hashCodeTest() throws Exception {
        StudentId sId = StudentId.getInstance();
        assertNotEquals(studentId.hashCode(), sId.hashCode());
    }
}