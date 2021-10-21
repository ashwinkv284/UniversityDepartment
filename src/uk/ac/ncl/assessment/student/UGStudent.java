package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.helper.Utils;

import java.util.Date;

public class UGStudent extends AbstractStudent {
    private final static int numberOfCredits = 120;
    private final static int passPercentage  = 40;
    /**
     * Returns instance of the class
     *
     * @param studentType - type of student
     * @param firstName   - firstName of student
     * @param lastName    - lastName of student
     * @param dateOfBirth - dateOfBirth of student
     */
    public UGStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        super(studentType, firstName, lastName, dateOfBirth);
    }
    /**
     * Generates smart card for student
     *
     */
    @Override
    public void setSmartCard() throws Exception {
        int ageOfStudent = Utils.calculateAge(this.getStudentDoB());
        if (ageOfStudent >= 17) {
            super.setSmartCard();
        } else {
            System.err.println("UG Student below 17 years old is not eligible for Smart Card");
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
