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
    /**
     * Returns instance of the class
     *
     * @param studentType - type of student
     * @param firstName   - firstName of student
     * @param lastName    - lastName of student
     * @param dateOfBirth - dateOfBirth of student
     */
    public AbstractStudent(String studentType, String firstName, String lastName, Date dateOfBirth) {
        this.studentType = studentType;
        this.dateOfBirth = dateOfBirth;
        this.studentName = new StudentName(firstName, lastName);
    }
    /**
     * Returns studentType
     *
     * @return - String - type of student
     */
    public String getStudentType() {
        return this.studentType;
    }
    /**
     * Returns studentName
     *
     * @return - StudentName - name of student
     */
    public StudentName getStudentName() {
        return this.studentName;
    }
    /**
     * Returns date Of Birth of student
     *
     * @return - Date - date of birth
     */
    public Date getStudentDoB() {
        return this.dateOfBirth;
    }
    /**
     * Returns StudentId of student
     *
     * @return - StudentId
     */
    public StudentId getStudentId() {
        return this.studentId;
    }
    /**
     * Sets auto generated studentId
     *
     * @throws Exception when studentId already exists
     */
    public void setStudentId() throws Exception {
        this.studentId = StudentId.getInstance();
    }
    /**
     * Sets already generated studentId
     *
     * @param studentId  - id of student
     */
    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }
    /**
     * Returns List of student modules
     *
     * @return - List of modules
     */
    public List<Module> getStudentModules() {
        return this.studentModules;
    }
    /**
     * Sets List of student modules
     *
     * @param modules -  list of modules
     */
    public void setStudentModules(List<Module> modules) {
        this.studentModules = modules;
    }
    /**
     * Returns smartcard of student
     *
     * @return - SmartCard
     */
    public SmartCard getSmartCard() {
        return this.smartCard;
    }
    /**
     * Sets smart card for student
     *
     * @throws Exception when smart card is already provided to student
     */
    public void setSmartCard() throws Exception {
        if (this.smartCard == null) {
            this.smartCard = SmartCard.getInstance(this.studentName.getFirstName(),
                                                   this.studentName.getLastName(),
                                                   this.dateOfBirth, this.studentType);
        } else {
            throw new Exception("Smart Card already provided to student");
        }
    }
    /**
     * Sets already generated smart card
     *
     * @param smartCard -  smartCard of student
     */
    public void setSmartCard(SmartCard smartCard) {
        this.smartCard = smartCard;
    }
    /**
     * Checks if the student is registered for enough credit
     *
     * @return true if student have enough credits, false if student doesn't have enough credits
     */
    public boolean checkEnoughCredit() {
        return true;
    }

}
