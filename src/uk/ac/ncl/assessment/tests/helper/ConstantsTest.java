package uk.ac.ncl.assessment.tests.helper;

import org.junit.Test;
import uk.ac.ncl.assessment.helper.Constants;

import static org.junit.Assert.assertEquals;

public class ConstantsTest {
    @Test
    public void constantsTest() {
        assertEquals("Undergraduate", Constants.UG);
        assertEquals("Postgraduate Taught", Constants.PGT);
        assertEquals("Postgraduate Research", Constants.PGR);
    }
}