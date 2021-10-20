package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.SmartCardNumber;

import static org.junit.Assert.*;

public class SmartCardNumberTest {
    SmartCardNumber smartCardNumber;
    @Before
    public void setUp() {
        smartCardNumber = SmartCardNumber.getInstance("John", "Doe");
    }
    @Test
    public void getInstanceTest() {
        assertNotNull(smartCardNumber);
    }
    @Test
    public void testToString() {
        assertNotNull(smartCardNumber.toString());
    }
}