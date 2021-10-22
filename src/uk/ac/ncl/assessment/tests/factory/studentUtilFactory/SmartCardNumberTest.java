package uk.ac.ncl.assessment.tests.factory.studentUtilFactory;

import org.junit.Test;
import uk.ac.ncl.assessment.factory.studentUtilFactory.SmartCardNumber;

import java.util.Random;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class SmartCardNumberTest {
    Random r = new Random();
    @Test
    public void getInstanceTest() throws Exception {
        SmartCardNumber smartCardNumber = SmartCardNumber.getInstance(r.nextInt(10000) + "John", "Doe");
        assertNotNull(smartCardNumber);
    }
    @Test
    public void testToString() throws Exception {
        SmartCardNumber smartCardNumber = SmartCardNumber.getInstance(r.nextInt(10000) + "John", "Doe");
        assertNotNull(smartCardNumber.toString());
    }
    @Test
    public void equalsTest() throws Exception {
        SmartCardNumber smartCardNumber = SmartCardNumber.getInstance(r.nextInt(10000) + "John", "Doe");
        SmartCardNumber scNo = SmartCardNumber.getInstance("Lorem", "Ipsum");
        assertNotEquals(smartCardNumber, scNo);
    }
    @Test
    public void hashCodeTest() throws Exception {
        SmartCardNumber smartCardNumber = SmartCardNumber.getInstance(r.nextInt(10000) + "John", "Doe");
        SmartCardNumber scNo = SmartCardNumber.getInstance("2Lorem", "2Ipsum");
        assertNotEquals(scNo.hashCode(), smartCardNumber.hashCode());
    }
}