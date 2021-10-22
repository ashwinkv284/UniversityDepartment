package uk.ac.ncl.assessment.tests.student;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.student.AbstractStudent;
import uk.ac.ncl.assessment.student.UGStudent;

import java.util.*;

import static org.junit.Assert.*;

public class AbstractStudentTest {
    Random r = new Random();
    @Before
    public void setUp() {

    }

    @Test
    public void getStudentIdTest() {
        List<Module> m = new ArrayList<Module>();
        AbstractStudent a = new UGStudent("Undergraduate", r.nextInt(10000) + "John", r.nextInt(10000) + "Doe", new Date());
        try {
            a.setStudentId();
        } catch(Exception e) {
            assertNull(e);
        }
        assertNotNull(a.getStudentId().toString());
    }

    @Test
    public void getStudentNameTest() {
        List<Module> m = new ArrayList<Module>();
        AbstractStudent a = new UGStudent("Undergraduate", r.nextInt(10000) + "John", r.nextInt(10000) + "Doe", new Date());
        assertNotNull(a.getStudentName().toString());
    }

    @Test
    public void getStudentTypeTest() {
        List<Module> m = new ArrayList<Module>();
        AbstractStudent a = new UGStudent("Undergraduate", r.nextInt(10000) + "John", r.nextInt(10000) + "Doe", new Date());
        assertEquals("getStudentType returns Undergraduate", "Undergraduate", a.getStudentType());
    }

    @Test
    public void getStudentModulesTest() throws Exception {
        List<Module> m = new ArrayList<Module>();
        Module mod = Module.getInstance("8501", "Advanced Programming in Java", 10);
        m.add(mod);
        AbstractStudent a = new UGStudent("Undergraduate", r.nextInt(10000) + "John", r.nextInt(10000) + "Doe", new Date());
        a.setStudentModules(m);
        List<Module> sModList = a.getStudentModules();
        assertTrue(m.size() == sModList.size() && m.containsAll(sModList) && sModList.containsAll(m));
    }

    @Test
    public void getStudentDoBTest() {
        List<Module> m = new ArrayList<Module>();
        Calendar cal = Calendar.getInstance();
        cal.set(1990, 1, 1);
        AbstractStudent a = new UGStudent("Undergraduate", r.nextInt(10000) + "John", r.nextInt(10000) + "Doe", cal.getTime());
        assertEquals("getStudentDoB returns correct DoB of student", cal.getTime(), a.getStudentDoB());
    }

    @Test
    public void checkEnoughCreditTest() {
        List<Module> m = new ArrayList<Module>();
        AbstractStudent a = new UGStudent("Undergraduate", r.nextInt(10000) + "John", r.nextInt(10000) + "Doe", new Date());
        assertEquals("The student does not have enough credit", false, a.checkEnoughCredit());
    }
}
