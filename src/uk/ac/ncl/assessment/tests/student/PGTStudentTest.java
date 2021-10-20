package uk.ac.ncl.assessment.tests.student;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.helper.Constants;
import uk.ac.ncl.assessment.student.PGTStudent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PGTStudentTest {
    Calendar cal;
    PGTStudent pgtStudent;
    @Before
    public void setUp() {
        cal  = Calendar.getInstance();
        cal.set(1990, 1, 1);
        pgtStudent = new PGTStudent(Constants.PGR, "John", "Doe", cal.getTime());
    }
    @Test
    public void PGRStudentSetSmartCardTest() {
        try {
            pgtStudent.setSmartCard();
        } catch(Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void PGRStudentSetSmartCardBelowAge() {
        pgtStudent = new PGTStudent(Constants.PGR, "John", "Doe", new Date());
        try {
            pgtStudent.setSmartCard();
        } catch(Exception e) {
            assertEquals("PG Students below 20 years old is not eligible for Smart Card" ,e.getMessage());
        }
    }
    @Test
    public void checkEnoughCreditTest() {
        List<Module> modules = new ArrayList<Module>();
        modules.add(Module.getInstance("CSC8404", "Advanced Programming in Java", 10));
        pgtStudent.setStudentModules(modules);
        assertFalse(pgtStudent.checkEnoughCredit());
    }
}
