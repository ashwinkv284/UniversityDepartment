package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;

import static org.junit.Assert.*;

public class StudentIdTest {
    StudentId studentId;
    StudentId nullStudentId;
    @Before
    public void setUp() {
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
    public void equalsTest() {
        StudentId sId = StudentId.getInstance();
        assertNotEquals(studentId, sId);
    }

    @Test
    public void hashCodeTest() {
        StudentId sId = StudentId.getInstance();
        assertNotEquals(studentId.hashCode(), sId.hashCode());
    }
}