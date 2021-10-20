package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.ncl.assessment.factory.studentUtilFactory.SmartCard;
import uk.ac.ncl.assessment.helper.Constants;

import java.util.Calendar;
import java.util.Date;

public class SmartCardTest {
    Calendar cal;
    SmartCard smartCard;
    @Before
    public void setUp() {
        cal  = Calendar.getInstance();
        cal.set(1990, 1, 1);
        smartCard = SmartCard.getInstance("John", "Doe", cal.getTime(), Constants.UG);
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
        assertEquals(new Date(), smartCard.getDateOfIssue());
    }
    @Test
    public void getDateOfExpiryTest() {Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 4);
        assertEquals(c.getTime(), smartCard.getExpiryDate());
    }
}
