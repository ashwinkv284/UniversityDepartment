package uk.ac.ncl.assessment.university;

import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.student.Student;

public interface University {
    /**
     * Returns number of students registered
     *
     * @return  int - number of students
     */
    int getNoOfStudents();
    /**
     * Used to register students to the university
     *
     * @param   student - object of student class with details of student
     * @return  boolean - returns true when student is successfully registered, otherwise throws exception
     * @throws Exception when registration of student is not successful
     */
    boolean registerStudent(Student student) throws Exception;
    /**
     * Used to update student data
     *
     * @param  student - object of student class with details of student
     * @param  studentId - id of the student
     * @return boolean - returns true when student is successfully updated, otherwise throws exception
     * @throws Exception when update of student is not successful
     */
    boolean amendStudentData(StudentId studentId, Student student) throws Exception;
    /**
     * Used to remove student data
     *
     * @param studentId - id of the studentId
     * @return  boolean - returns true when student is successfully removed, otherwise throws exception
     * @throws Exception when termination of student is not successful
     */
    boolean terminateStudent(StudentId studentId) throws Exception;
}
