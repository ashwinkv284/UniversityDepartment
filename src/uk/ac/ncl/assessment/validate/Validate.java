package uk.ac.ncl.assessment.validate;

import java.util.HashMap;

public final class Validate {
    /**
     * Validate params of
     *
     * @param fieldToVal - map of fieldName to fieldValue
     * @throws Exception when param is null
     */
    public static void validateParams(HashMap<String, Object> fieldToVal) throws Exception {
        for (String fieldName : fieldToVal.keySet()) {
            if(fieldToVal.get(fieldName) == null) {
                throw new Exception(fieldName + " cannot be null");
            }
        }
    }
}
