package uk.ac.ncl.assessment.tests.student;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;
import uk.ac.ncl.assessment.helper.Constants;
import uk.ac.ncl.assessment.student.PGRStudent;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PGRStudentTest {
    Calendar cal;
    PGRStudent pgrStudent;
    @Before
    public void setUp() {
        cal  = Calendar.getInstance();
        cal.set(1990, 1, 1);
        pgrStudent = new PGRStudent(Constants.PGR, "John", "Doe", cal.getTime());
    }
    @Test
    public void PGRStudentSupervisorTest() throws Exception {
        Supervisor supervisor = Supervisor.getInstance("Jane", "Doe", "jane2@ncl.ac.uk");
        pgrStudent.setSupervisor(supervisor);
        assertEquals(pgrStudent.getSupervisor(), supervisor);
        assertEquals(pgrStudent.getSupervisor().hashCode(), supervisor.hashCode());
    }
    @Test
    public void PGRStudentSetSmartCardTest() {
        try {
            pgrStudent.setSmartCard();
        } catch(Exception e) {
            assertNull(e);
        }
    }
    @Test
    public void PGRStudentSetSmartCardBelowAge() {
        pgrStudent = new PGRStudent(Constants.PGR, "John", "Doe1", new Date());
        try {
            pgrStudent.setSmartCard();
        } catch(Exception e) {
            assertEquals("PG Students below 20 years old is not eligible for Smart Card" ,e.getMessage());
        }
    }
    @Test
    public void PGRStudentModuleTest() {
        pgrStudent.setStudentModules(null);
    }
    @Test
    public void passPercentageTest() {
        assertEquals(50, pgrStudent.getPassPercentage());
    }

}
