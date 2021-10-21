package uk.ac.ncl.assessment.university;

import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.student.Student;

public interface UniversityI {
    int getNoOfStudents();
    boolean registerStudent(Student student) throws Exception;
    boolean amendStudentData(StudentId studentId, Student student) throws Exception;
    boolean terminateStudent(StudentId studentId) throws Exception;
}
