package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentName;

import java.util.Date;
import java.util.List;

public interface Student {
    /**
     * Returns StudentId of student
     *
     * @return - StudentId
     */
    StudentId getStudentId();
    /**
     * Returns studentName
     *
     * @return - StudentName - name of student
     */
    StudentName getStudentName();
    /**
     * Returns date Of Birth of student
     *
     * @return - Date - date of birth
     */
    Date getStudentDoB();
    /**
     * Returns studentType
     *
     * @return - String - type of student
     */
    String getStudentType();
    /**
     * Returns List of student modules
     *
     * @return - List of modules
     */
    List<Module> getStudentModules();
    /**
     * Checks if the student is registered for enough credit
     *
     * @return true if student have enough credits, false if student doesn't have enough credits
     */
    boolean checkEnoughCredit();
}
