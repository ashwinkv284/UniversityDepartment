package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.helper.Utils;

import java.util.Date;

public class UGStudent extends AbstractStudent {
    private final static int numberOfCredits = 120;
    private final static int passPercentage  = 40;
    public UGStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        super(studentType, firstName, lastName, dateOfBirth);
    }

    @Override
    public void setSmartCard() throws Exception {
        int ageOfStudent = Utils.calculateAge(this.getStudentDoB());
        if (ageOfStudent >= 17) {
            super.setSmartCard();
        } else {
            System.err.println("Student below 17 years old is not eligible for Smart Card");
        }
    }

    @Override
    public Boolean checkEnoughCredit() {
        return Utils.checkEnoughCredit(this.getStudentModules(), numberOfCredits);
    }
}
