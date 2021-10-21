package uk.ac.ncl.assessment.tests.university;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.student.PGRStudent;
import uk.ac.ncl.assessment.student.PGTStudent;
import uk.ac.ncl.assessment.student.UGStudent;
import uk.ac.ncl.assessment.university.Department;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentTest {
    Department department;
    @Before
    public void setUp() throws Exception {
        department = Department.getInstance();
    }

    @Test
    public void registerUGStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(department.getAllModules().values());
        s.setStudentModules(modules);
        Boolean regSuccess = null;
        try {
            regSuccess = department.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) regSuccess);
        assertNotNull("Student id is not null", s.getStudentId());
        try {
            department.terminateStudent(s.getStudentId());
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void registerPGTStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        PGTStudent s = new PGTStudent("Postgraduate Taught","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(department.getAllModules().values());
        s.setStudentModules(modules);
        Boolean regSuccess = null;
        try {
            regSuccess = department.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertEquals(true, (boolean) regSuccess);
        try {
            department.terminateStudent(s.getStudentId());
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void registerPGRStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        PGRStudent s = new PGRStudent("Postgraduate Research","John", "Doe",cal.getTime());
        Boolean regSuccess = false;
        try {
            regSuccess = department.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        assertTrue((boolean) regSuccess);
        assertNotNull(s.getSupervisor().getEmail());
        try {
            department.terminateStudent(s.getStudentId());
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void amendStudentDataTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(department.getAllModules().values());
        s.setStudentModules(modules);
        try {
            department.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        Module mod = Module.getInstance("CSC8201", "Big Data Analytics", 10);
        modules.add(mod);
        try {
            department.amendStudentData(s.getStudentId(), s);
            List<Module> sModList = s.getStudentModules();
            assertTrue(modules.size() == sModList.size() && modules.containsAll(sModList) && sModList.containsAll(modules));
        } catch (Exception e) {
            assertNull(e);
        }
        try {
            department.terminateStudent(s.getStudentId());
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void terminateStudentTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        UGStudent s = new UGStudent("Undergraduate","John", "Doe",cal.getTime());
        ArrayList<Module> modules = new ArrayList<Module>(department.getAllModules().values());
        s.setStudentModules(modules);
        try {
            department.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        try {
            Boolean terminateSuccess = department.terminateStudent(s.getStudentId());
            assertTrue((boolean) terminateSuccess);
        } catch (Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void terminateStudentWithNullStudentIdTest() {
        try {
            department.terminateStudent(null);
        } catch (Exception e) {
            assertEquals("StudentId cannot be null", e.getMessage());
        }
    }
    @Test
    public void terminateStudentWithNonExistentStudentIdTest() {
        StudentId sId = StudentId.getInstance();
        try {
            department.terminateStudent(sId);
        } catch (Exception e) {
            assertEquals("Student does not exist", e.getMessage());
        }
    }
    @Test
    public void loadModulesAndSupervisorsTest() {
        assertNotNull(department.getAllModules());
        assertNotNull(department.getAllSupervisors());
    }
    @Test
    public void noOfStudentsWithRecordsTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        PGRStudent s = new PGRStudent("Postgraduate Research","John", "Doe",cal.getTime());
        try {
           department.registerStudent(s);
        } catch (Exception e) {
            assertNull(e);
        }
        int noOfStudents = department.getNoOfStudents();
        assertEquals("University has 0 number of students", 1, noOfStudents);
    }
}
