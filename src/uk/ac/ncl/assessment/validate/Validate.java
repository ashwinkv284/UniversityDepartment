package uk.ac.ncl.assessment.validate;

import java.util.HashMap;

public final class Validate {
    public static void validateParams(HashMap<String, Object> fieldToVal) throws Exception {
        for (String fieldName : fieldToVal.keySet()) {
            if(fieldToVal.get(fieldName) == null) {
                throw new Exception(fieldName + " cannot be null");
            }
        }
    }
}
