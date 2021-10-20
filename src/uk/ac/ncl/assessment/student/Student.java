package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;

import java.util.List;

public interface Student {
    StudentId getStudentId();
    String getStudentType();
    List<Module> getStudentModules();
    boolean checkEnoughCredit();
}
