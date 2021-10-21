package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.helper.Utils;

import java.util.Date;

public class PGTStudent extends AbstractStudent {
    private final static int numberOfCredits = 180;
    private final static int passPercentage  = 50;
    /**
     * Returns instance of the class
     *
     * @param studentType - type of student
     * @param firstName   - firstName of student
     * @param lastName    - lastName of student
     * @param dateOfBirth - dateOfBirth of student
     */
    public PGTStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        super(studentType, firstName, lastName, dateOfBirth);
    }
    /**
     * Generates smart card for student
     *
     */
    @Override
    public void setSmartCard() throws Exception {
        int ageOfStudent = Utils.calculateAge(this.getStudentDoB());
        if (ageOfStudent >= 20) {
            super.setSmartCard();
        } else {
            System.err.println("PG Students below 20 years old is not eligible for Smart Card");
        }
    }
    /**
     * Checks if the student is registered for enough credit
     *
     * @return true if student have enough credits, false if student doesn't have enough credits
     */
    @Override
    public boolean checkEnoughCredit() {
        return Utils.checkEnoughCredit(this.getStudentModules(), numberOfCredits);
    }
    /**
     * returns pass percentage required
     *
     * @return passPercentage
     */
    public int getPassPercentage() {
        return passPercentage;
    }
}
