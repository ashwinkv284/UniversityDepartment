package uk.ac.ncl.assessment.tests.student;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.helper.Constants;
import uk.ac.ncl.assessment.student.UGStudent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UGStudentTest {
    Calendar cal;
    UGStudent ugStudent;
    @Before
    public void setUp() {
        cal  = Calendar.getInstance();
        cal.set(1990, 1, 1);
        ugStudent = new UGStudent(Constants.UG, "John", "Doe", cal.getTime());
    }
    @Test
    public void UGStudentSetSmartCardTest() {
        try {
            ugStudent.setSmartCard();
        } catch(Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void UGStudentSetSmartCardBelowAge() {
        ugStudent = new UGStudent(Constants.PGR, "John", "Doe", new Date());
        try {
            ugStudent.setSmartCard();
        } catch(Exception e) {
            assertEquals("UG Students below 20 years old is not eligible for Smart Card" ,e.getMessage());
        }
    }
    @Test
    public void checkEnoughCreditTest() {
        List<Module> modules = new ArrayList<Module>();
        modules.add(Module.getInstance("CSC8404", "Advanced Programming in Java", 10));
        ugStudent.setStudentModules(modules);
        assertFalse(ugStudent.checkEnoughCredit());
    }
    @Test
    public void passPercentageTest() {
        assertEquals(40, ugStudent.getPassPercentage());
    }
}
