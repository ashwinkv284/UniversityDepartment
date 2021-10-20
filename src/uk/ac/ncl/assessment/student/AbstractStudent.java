package uk.ac.ncl.assessment.student;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.SmartCard;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentName;

import java.util.Date;
import java.util.List;

public abstract class AbstractStudent implements Student {
    private final String studentType;
    private final StudentName studentName;
    private final Date dateOfBirth;
    private List<Module> studentModules;
    private SmartCard smartCard;
    private StudentId studentId;

    public AbstractStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        this.studentType = studentType;
        this.dateOfBirth = dateOfBirth;
        this.studentName = new StudentName(firstName, lastName);
    }

    public String getStudentType() {
        return this.studentType;
    }

    public StudentName getStudentName() {
        return this.studentName;
    }

    public Date getStudentDoB() {
        return this.dateOfBirth;
    }

    public StudentId getStudentId() {
        return this.studentId;
    }

    public void setStudentId() {
        this.studentId = StudentId.getInstance();
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

    public List<Module> getStudentModules() {
        return this.studentModules;
    }

    public void setStudentModules(List<Module> modules) {
        this.studentModules = modules;
    }

    public SmartCard getSmartCard() {
        return this.smartCard;
    }

    public void setSmartCard() throws Exception {
        if (this.smartCard == null) {
            this.smartCard = SmartCard.getInstance(this.studentName.getFirstName(),
                                                   this.studentName.getLastName(),
                                                   this.dateOfBirth);
        } else {
            throw new Exception("Smart Card already provided to student");
        }
    }

    public void setSmartCard(SmartCard smartCard) {
        this.smartCard = smartCard;
    }

    public Boolean checkEnoughCredit() {
        return true;
    }

}
