package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;

import java.util.List;

public interface Student {
    /**
     * Returns StudentId of student
     *
     * @return - StudentId
     */
    StudentId getStudentId();
    /**
     * Returns studentType
     *
     * @return - String - type of student
     */
    String getStudentType();
    /**
     * Returns List of student modules
     *
     * @return - List<Module>
     */
    List<Module> getStudentModules();
    /**
     * Checks if the student is registered for enough credit
     *
     * @return true if student have enough credits, false if student doesn't have enough credits
     */
    boolean checkEnoughCredit();
}
