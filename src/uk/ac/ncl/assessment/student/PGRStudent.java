package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;
import uk.ac.ncl.assessment.helper.Utils;

import java.util.Date;
import java.util.List;

public class PGRStudent extends AbstractStudent{
    private final static int passPercentage  = 50;
    private final static int minAge          = 20;
    private Supervisor supervisor;
    /**
     * Returns instance of the class
     *
     * @param studentType - type of student
     * @param firstName   - firstName of student
     * @param lastName    - lastName of student
     * @param dateOfBirth - dateOfBirth of student
     */
    public PGRStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        super(studentType, firstName, lastName, dateOfBirth);
    }
    /**
     * allocates supervisor to PGR students
     *
     * @param supervisor - supervisor to student
     */
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
    /**
     * returns the supervisor of the student
     *
     * @return Supervisor of the student
     */
    public Supervisor getSupervisor() {
        return this.supervisor;
    }
    /**
     * Generates smart card for student
     *
     */
    @Override
    public void setSmartCard() throws Exception {
        int ageOfStudent = Utils.calculateAge(this.getStudentDoB());
        if (ageOfStudent >= minAge) {
            super.setSmartCard();
        } else {
            throw new Exception("PG Students below 20 years old is not eligible for Smart Card");
        }
    }
    /**
     * allocates modules for student
     *
     * @param modules - list of modules for student
     */
    @Override
    public void setStudentModules(List<Module> modules) {
        //does nothing as PGR Students does not need to register for modules
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
