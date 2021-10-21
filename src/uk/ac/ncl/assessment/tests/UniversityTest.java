package uk.ac.ncl.assessment.tests;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.University;
import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.student.PGRStudent;
import uk.ac.ncl.assessment.student.PGTStudent;
import uk.ac.ncl.assessment.student.UGStudent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class UniversityTest {
    University uni;
    @Before
    public void setUp() throws Exception {
        uni = University.getInstance();
    }
    @Test
    public void noOfStudentsTest() {
        int noOfStudents = uni.getNoOfStudents();
        assertEquals("University has 0 number of students", 0, noOfStudents);
    }
    @Test
    public void registerUGStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(uni.getAllModules().values());
        s.setStudentModules(modules);
        Boolean regSuccess = null;
        try {
            regSuccess = uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) regSuccess);
        assertNotNull("Student id is not null", s.getStudentId());
    }
    @Test
    public void registerPGTStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        PGTStudent s = new PGTStudent("Postgraduate Taught","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(uni.getAllModules().values());
        s.setStudentModules(modules);
        Boolean regSuccess = null;
        try {
            regSuccess = uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) regSuccess);
    }
    @Test
    public void registerPGRStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        PGRStudent s = new PGRStudent("Postgraduate Research","John", "Doe",cal.getTime());
        Boolean regSuccess = null;
        try {
            regSuccess = uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertTrue((boolean) regSuccess);
        assertNotNull(s.getSupervisor().getEmail());
    }
    @Test
    public void amendStudentDataTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(uni.getAllModules().values());
        s.setStudentModules(modules);
        try {
            uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        Module mod = Module.getInstance("CSC8201", "Big Data Analytics", 10);
        modules.add(mod);
        try {
            uni.amendStudentData(s.getStudentId(), s);
            List<Module> sModList = s.getStudentModules();
            assertTrue(modules.size() == sModList.size() && modules.containsAll(sModList) && sModList.containsAll(modules));
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void terminateStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(uni.getAllModules().values());
        s.setStudentModules(modules);
        try {
            uni.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        try {
            Boolean terminateSuccess = uni.terminateStudent(s.getStudentId());
            assertTrue((boolean) terminateSuccess);
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void terminateStudentWithNullStudentIdTest() {
        try {
            uni.terminateStudent(null);
        } catch (Exception e) {
            assertEquals("Invalid Student Id", e.getMessage());
        }
    }
    @Test
    public void terminateStudentWithNonExistentStudentIdTest() {
        StudentId sId = StudentId.getInstance();
        try {
            uni.terminateStudent(sId);
        } catch (Exception e) {
            assertEquals("Student Id does not exist", e.getMessage());
        }
    }
    @Test
    public void loadModulesAndSupervisorsTest() {
        assertNotNull(uni.getAllModules());
        assertNotNull(uni.getAllSupervisors());
    }
}
