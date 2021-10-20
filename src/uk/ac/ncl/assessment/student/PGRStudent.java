package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;
import uk.ac.ncl.assessment.helper.Utils;

import java.util.Date;
import java.util.List;

public class PGRStudent extends AbstractStudent{
    private final static int passPercentage  = 50;
    private Supervisor supervisor;
    public PGRStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        super(studentType, firstName, lastName, dateOfBirth);
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Supervisor getSupervisor() {
        return this.supervisor;
    }

    @Override
    public void setSmartCard() throws Exception {
        int ageOfStudent = Utils.calculateAge(this.getStudentDoB());
        if (ageOfStudent >= 20) {
            super.setSmartCard();
        } else {
            System.err.println("Students below 20 years old is not eligible for Smart Card");
        }
    }

    @Override
    public void setStudentModules(List<Module> modules) {
        System.out.println("PGR Students does not need to register for modules");
    }
}
