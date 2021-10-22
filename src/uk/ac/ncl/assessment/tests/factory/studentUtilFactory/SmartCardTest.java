package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.SmartCard;
import uk.ac.ncl.assessment.helper.Constants;

import java.util.Calendar;
import java.util.Random;

import static org.junit.Assert.*;

public class SmartCardTest {
    Calendar cal;
    SmartCard smartCard;
    Random r = new Random();
    @Before
    public void setUp() throws Exception {
        int code = r.nextInt(10000);
        cal  = Calendar.getInstance();
        cal.set(1990, 1, 1);
        smartCard = SmartCard.getInstance(code + "Tony", code + "Doe", cal.getTime(), Constants.UG);
    }
    @Test
    public void getSmartCardNumberTest() {
        assertNotNull(smartCard.getSmartCardNumber());
    }
    @Test
    public void getDateOfBirthTest() {
        assertEquals(cal.getTime(), smartCard.getDateOfBirth());
    }
    @Test
    public void getDateOfIssueTest() {
        assertNotNull(smartCard.getDateOfIssue());
    }
    @Test
    public void getDateOfExpiryTest() {
        Calendar c = Calendar.getInstance();
        c.setTime(smartCard.getDateOfIssue());
        c.add(Calendar.YEAR, 4);
        assertEquals(c.getTime(), smartCard.getExpiryDate());
    }
    @Test
    public void equalsTest() throws Exception {
        SmartCard sc = SmartCard.getInstance("Lorem", "Ipsum", cal.getTime(), Constants.UG);
        assertNotEquals(smartCard, sc);
    }
    @Test
    public void hashCodeTest() throws Exception {
        SmartCard sc = SmartCard.getInstance("1Lorem", "1Ipsum", cal.getTime(), Constants.UG);
        assertNotEquals(sc.hashCode(), smartCard.hashCode());
    }
}
