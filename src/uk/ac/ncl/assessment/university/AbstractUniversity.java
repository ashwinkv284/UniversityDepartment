package uk.ac.ncl.assessment.university;

import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.student.AbstractStudent;
import uk.ac.ncl.assessment.student.Student;

import java.util.HashMap;

public class AbstractUniversity implements University {
    private static final HashMap<String, Student> allStudents = new HashMap<String, Student>();
    /**
     * Returns number of students registered
     *
     * @return  int - number of students
     */
    public int getNoOfStudents() {
        return allStudents.size();
    }
    /**
     * Used to register students to the university
     *
     * @param   student - object of student class with details of student
     * @return  boolean - returns true when student is successfully registered, otherwise throws exception
     * @throws Exception when registration of student is not successful
     */
    public boolean registerStudent(Student student) throws Exception {
        allStudents.put(student.getStudentId().toString(), student);
        return true;
    }
    /**
     * Used to update student data
     *
     * @param  student - object of student class with details of student
     * @param  studentId - id of the student
     * @return boolean - returns true when student is successfully updated, otherwise throws exception
     * @throws Exception when update of student is not successful
     */
    public boolean amendStudentData(StudentId studentId, Student student) throws Exception {
        AbstractStudent oldStudentData = (AbstractStudent)allStudents.get(studentId.toString());
        AbstractStudent newStudentData = (AbstractStudent) student;
        newStudentData.setStudentId(studentId);
        newStudentData.setSmartCard(oldStudentData.getSmartCard());
        allStudents.put(studentId.toString(), newStudentData);
        return true;
    }
    /**
     * Used to remove student data
     *
     * @param studentId - id of the studentId
     * @return  boolean - returns true when student is successfully removed, otherwise throws exception
     * @throws Exception when termination of student is not successful
     */
    public boolean terminateStudent(StudentId studentId) throws Exception {
        allStudents.remove(studentId.toString());
        return true;
    }
    /**
     * Used to check if the student exists
     *
     * @param studentId - id of the studentId
     * @return  boolean - returns true when student exists, othersise returns false
     */
    public boolean checkStudentExists(StudentId studentId) {
        return allStudents.containsKey(studentId.toString());
    }
}
