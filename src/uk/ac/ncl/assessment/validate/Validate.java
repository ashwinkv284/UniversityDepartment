package uk.ac.ncl.assessment.validate;

import uk.ac.ncl.assessment.helper.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Validate {
    /**
     * Validate params of
     *
     * @param fieldToVal - map of fieldName to fieldValue
     * @throws Exception when param is null
     */
    public static void validateParams(HashMap<String, Object> fieldToVal) throws Exception {
        for (String fieldName : fieldToVal.keySet()) {
            Object fieldValue = fieldToVal.get(fieldName);
            if(fieldValue == null) {
                throw new Exception(fieldName + " cannot be null");
            } else {
                List<String> studentTypes = new ArrayList<String>() {{
                    add(Constants.UG);
                    add(Constants.PGT);
                    add(Constants.PGR);
                }};
                if (fieldName.equals("Student Type") && !studentTypes.contains(fieldValue.toString())) {
                    throw new Exception("Invalid Student Type");
                }
            }
        }
    }
}
