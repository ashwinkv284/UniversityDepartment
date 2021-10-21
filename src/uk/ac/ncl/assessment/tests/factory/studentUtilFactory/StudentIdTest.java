package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
}