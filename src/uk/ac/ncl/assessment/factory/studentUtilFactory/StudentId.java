package uk.ac.ncl.assessment.factory.studentUtilFactory;

import java.util.HashSet;
import java.util.Random;

public final class StudentId {
    private final String studentId;
    private final static HashSet<String> allStudentIds = new HashSet<String>();
    /**
     * Returns instance of the class
     *
     * @param studentId    - id of student
     */
    private StudentId(String studentId) {
        this.studentId = studentId;
    }
    /**
     * Returns instance of the class

     * @return - Instance of class
     */
    public static StudentId getInstance() {
        Random rand = new Random();
        String studentId = String.valueOf((char)((char)rand.nextInt(26) + 'a'))
                           + String.valueOf(rand.nextInt(10000));
        if(!allStudentIds.contains(studentId)) {
            allStudentIds.add(studentId);
        } else {
            System.err.println("StudentId already exists");
        }
        return new StudentId(studentId);
    }
    public String getStudentId() {
        return this.studentId;
    }
    /**
     * Returns string value of object
     *
     * @return - string value of student id
     */
    @Override
    public String toString() {
        return this.studentId;
    }
    /**
     * Checks if the two objects of the same class are equal
     *
     * @return boolean - true if equal, false if not equal
     */
    @Override
    public boolean equals(Object sId) {
        if(sId instanceof StudentId) {
            StudentId studentId = (StudentId) sId;
            return this.getStudentId().equals(studentId.getStudentId());
        }
        return false;
    }
    /**
     * Generates hashCode for the object
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + (this.getStudentId() == null ? 0 : this.getStudentId().hashCode());
        return hc;
    }
}
