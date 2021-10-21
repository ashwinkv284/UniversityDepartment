package uk.ac.ncl.assessment.tests.validate;

import org.junit.Test;
import uk.ac.ncl.assessment.validate.Validate;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ValidateTest {
    @Test
    public void validateParamsExceptionTest() {
        HashMap<String, Object> params = new HashMap<>() {{
            put("firstName", null);
        }};
        try {
            Validate.validateParams(params);
        } catch (Exception e) {
            assertEquals("firstName cannot be null", e.getMessage());
        }
    }
    @Test
    public void validateParamsTest() {
        HashMap<String, Object> params = new HashMap<>() {{
            put("firstName", "John");
        }};
        try {
            Validate.validateParams(params);
        } catch (Exception e) {
            assertNull(e);
        }
    }
}
