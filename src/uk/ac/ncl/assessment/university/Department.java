package uk.ac.ncl.assessment.university;

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

public class Department extends AbstractUniversity {
    private static final HashMap<String, Module> allModules = new HashMap<String, Module>();
    private static final HashMap<String, Supervisor> allSupervisors = new HashMap<String, Supervisor>();
    private static Department department;

    /**
     * Returns instance of the class
     *
     * @return instance of university class
     * @throws Exception when loading of modules/supervisors is not successful
     */
    public static Department getInstance() throws Exception {
        if(department == null) {
            department = new Department();
            loadModules();
            loadSupervisors();
        }
        return department;
    }

    /**
     * Used to register students to the university
     *
     * @param   student - object of student class with details of student
     * @return  boolean - returns true when student is successfully registered, otherwise throws exception
     * @throws Exception when registration of student is not successful
     */
    @Override
    public boolean registerStudent(Student student) throws Exception {
        HashMap<String, Object> params = new HashMap<>() {{
            put("Student", student);
        }};
        Validate.validateParams(params);
        validateStudentParams(student, params);

        AbstractStudent stu = (AbstractStudent) student;
        stu.setStudentId();
        stu.setSmartCard();
        if(student.getStudentType().equals(Constants.PGR)) {
            Random random = new Random();
            PGRStudent pgrStu = (PGRStudent)stu;
            Object[] supervisorKeys = allSupervisors.keySet().toArray();
            String supervisorKey = (String)supervisorKeys[(random.nextInt(allSupervisors.keySet().size()))];
            pgrStu.setSupervisor(allSupervisors.get(supervisorKey));
        }
        return super.registerStudent(stu);
    }
    /**
     * Used to update student data
     *
     * @param  student - object of student class with details of student
     * @param  studentId - id of the student
     * @return boolean - returns true when student is successfully updated, otherwise throws exception
     * @throws Exception when update of student is not successful
     */
    @Override
    public boolean amendStudentData(StudentId studentId, Student student) throws Exception {
        HashMap<String, Object> params = new HashMap<>() {{
            put("Student", student);
            put("StudentId", studentId);
        }};
        Validate.validateParams(params);
        validateStudentParams(student, params);
        if(!checkStudentExists(studentId)) {
            throw new Exception("Student does not exist");
        }

        return super.amendStudentData(studentId, student);
    }
    /**
     * Used to remove student data
     *
     * @param studentId - id of the studentId
     * @return  boolean - returns true when student is successfully removed, otherwise throws exception
     * @throws Exception when termination of student is not successful
     */
    @Override
    public boolean terminateStudent(StudentId studentId) throws Exception {
        HashMap<String, Object> params = new HashMap<>() {{
            put("StudentId", studentId);
        }};
        Validate.validateParams(params);
        if(!checkStudentExists(studentId)) {
            throw new Exception("Student does not exist");
        }

        return super.terminateStudent(studentId);
    }
    /**
     * Used to retrieve all modules available in the university
     *
     * @return returns map of module code to module details
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
     * @return map of supervisor email to supervisor
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

    private void validateStudentParams(Student student, HashMap<String, Object> params) throws Exception {
        params.put("Student Name", student.getStudentName());
        params.put("Student Date of Birth", student.getStudentDoB());
        params.put("Student Type", student.getStudentType());
        Validate.validateParams(params);
    }
}
