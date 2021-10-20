package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.helper.Utils;

import java.util.Date;

public class PGTStudent extends AbstractStudent {
    private final static int numberOfCredits = 180;
    private final static int passPercentage  = 50;
    public PGTStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        super(studentType, firstName, lastName, dateOfBirth);
    }

    @Override
    public void setSmartCard() throws Exception {
        int ageOfStudent = Utils.calculateAge(this.getStudentDoB());
        if (ageOfStudent >= 20) {
            super.setSmartCard();
        } else {
            System.err.println("PG Students below 20 years old is not eligible for Smart Card");
        }
    }

    @Override
    public boolean checkEnoughCredit() {
        return Utils.checkEnoughCredit(this.getStudentModules(), numberOfCredits);
    }
}
