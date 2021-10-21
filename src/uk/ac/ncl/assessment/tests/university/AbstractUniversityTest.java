package uk.ac.ncl.assessment.tests.university;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.student.UGStudent;
import uk.ac.ncl.assessment.university.AbstractUniversity;
import uk.ac.ncl.assessment.university.Department;

import java.util.Calendar;

import static org.junit.Assert.*;

public class AbstractUniversityTest {
    AbstractUniversity uni;
    @Before
    public void setUp() throws Exception {
        uni = Department.getInstance();
    }
    @Test
    public void registerAndTerminateUGStudent() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        Boolean regSuccess = null;
        try {
            regSuccess = uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) regSuccess);
        assertNotNull("Student id is not null", s.getStudentId());
        assertTrue(uni.checkStudentExists(s.getStudentId()));
        try {
            uni.terminateStudent(s.getStudentId());
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void amendAndTerminateUGStudent() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        Boolean success = null;
        try {
            success = uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) success);
        assertNotNull("Student id is not null", s.getStudentId());
        try {
            success = uni.amendStudentData(s.getStudentId(), s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) success);
        try {
            uni.terminateStudent(s.getStudentId());
        } catch (Exception e) {
            assertNull(e);
        }
    }
}
