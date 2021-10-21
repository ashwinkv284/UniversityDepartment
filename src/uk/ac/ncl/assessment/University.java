package uk.ac.ncl.assessment;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;
import uk.ac.ncl.assessment.helper.Constants;
import uk.ac.ncl.assessment.student.AbstractStudent;
import uk.ac.ncl.assessment.student.PGRStudent;
import uk.ac.ncl.assessment.student.Student;
import uk.ac.ncl.assessment.validate.Validate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class University {
    private static final HashMap<String, Student> allStudents = new HashMap<String, Student>();
    private static final HashMap<String, Module> allModules = new HashMap<String, Module>();
    private static final HashMap<String, Supervisor> allSupervisors = new HashMap<String, Supervisor>();
    private static University uni;

    /**
     * Returns instance of the class
     *
     */
    public static University getInstance() throws Exception {
        if(uni == null) {
            uni = new University();
            loadModules();
            loadSupervisors();
        }
        return uni;
    }
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
     * @return  boolean - returns true when student is successfully registered, otherwise throws exception
     */
    public Boolean registerStudent(Student student) throws Exception {
        HashMap<String, Object> params = new HashMap<>() {{
            put("Student", student);
        }};
        Validate.validateParams(params);

        AbstractStudent stu = (AbstractStudent) student;
        stu.setStudentId();
        stu.setSmartCard();
        if(student.getStudentType().equals(Constants.PGR)) {
            Random random = new Random();
            PGRStudent pgrStu = (PGRStudent)stu;
            Object[] supervisorKeys = allSupervisors.keySet().toArray();
            String supervisorKey = (String)supervisorKeys[(random.nextInt(allSupervisors.keySet().size()))];
            pgrStu.setSupervisor(allSupervisors.get(supervisorKey));
            allStudents.put(pgrStu.getStudentId().toString(), pgrStu);
        } else {
            allStudents.put(stu.getStudentId().toString(), stu);
        }
        return true;
    }
    /**
     * Used to update student data
     *
     * @return  boolean - returns true when student is successfully updated, otherwise throws exception
     */
    public Boolean amendStudentData(StudentId studentId, Student student) throws Exception {
        HashMap<String, Object> params = new HashMap<>() {{
            put("Student", student);
            put("StudentId", studentId);
        }};
        Validate.validateParams(params);
        if(!allStudents.containsKey(studentId.toString())) {
            throw new Exception("Student does not exist");
        }

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
     * @return  boolean - returns true when student is successfully removed, otherwise throws exception
     */
    public Boolean terminateStudent(StudentId studentId) throws Exception {
        HashMap<String, Object> params = new HashMap<>() {{
            put("StudentId", studentId);
        }};
        Validate.validateParams(params);
        if(!allStudents.containsKey(studentId.toString())) {
            throw new Exception("Student does not exist");
        }
        allStudents.remove(studentId.toString());
        return true;
    }
    /**
     * Used to retrieve all modules available in the university
     *
     * @return  HashMap<String,Module> - returns map of module code to module details
     */
    public HashMap<String, Module> getAllModules() {
        return allModules;
    }
    /**
     * Used to load all modules
     *
     */
    private static void loadModules() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(System.getProperty("user.dir")
                                           + "/src/uk/ac/ncl/assessment/data/modules.csv"));) {
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(",");
                allModules.put(values[0], Module.getInstance(values[0], values[1], Integer.parseInt(values[2])));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File to load modules not found");
        }
    }
    /**
     * Used to retrieve all supervisors available in the university
     *
     * @return  HashMap<String,Supervisor> - returns map of supervisor email to supervisor
     */
    public HashMap<String, Supervisor> getAllSupervisors() {
        return allSupervisors;
    }
    /**
     * Used to load all supervisor from file
     *
     */
    private static void loadSupervisors() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(System.getProperty("user.dir")
                + "/src/uk/ac/ncl/assessment/data/supervisors.csv"));) {
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(",");
                allSupervisors.put(values[2], Supervisor.getInstance(values[0], values[1], values[2]));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File to load supervisors not found");
        }
    }
}
