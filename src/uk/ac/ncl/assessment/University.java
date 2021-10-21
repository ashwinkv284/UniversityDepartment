package uk.ac.ncl.assessment;

import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.factory.studentUtilFactory.StudentId;
import uk.ac.ncl.assessment.factory.supervisor.Supervisor;
import uk.ac.ncl.assessment.helper.Constants;
import uk.ac.ncl.assessment.student.AbstractStudent;
import uk.ac.ncl.assessment.student.PGRStudent;
import uk.ac.ncl.assessment.student.Student;

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

    public static University getInstance() throws Exception {
        if(uni == null) {
            uni = new University();
            try {
                loadModules();
                loadSupervisors();
            } catch (Exception e) {
                throw new Exception("Error while loading modules/supervisors");
            }
        }
        return uni;
    }

    public int getNoOfStudents() {
        return allStudents.size();
    }

    public Boolean registerStudent(Student student) throws Exception {
        checkValidStudent(student, false);
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
            return true;
        }
        allStudents.put(stu.getStudentId().toString(), stu);
        return true;
    }

    public Boolean amendStudentData(StudentId studentId, Student student) throws Exception {
        checkValidStudentId(studentId);
        checkValidStudent(student, true);
        AbstractStudent oldStudentData = (AbstractStudent)allStudents.get(studentId.toString());
        AbstractStudent newStudentData = (AbstractStudent) student;
        newStudentData.setStudentId(studentId);
        newStudentData.setSmartCard(oldStudentData.getSmartCard());
        allStudents.put(studentId.toString(), newStudentData);
        return true;
    }

    public Boolean terminateStudent(StudentId studentId) throws Exception {
        checkValidStudentId(studentId);
        allStudents.remove(studentId.toString());
        return true;
    }

    public HashMap<String, Module> getAllModules() {
        return allModules;
    }

    private static void loadModules() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(System.getProperty("user.dir")
                                           + "/src/uk/ac/ncl/assessment/data/modules.csv"));) {
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(",");
                allModules.put(values[0], Module.getInstance(values[0], values[1], Integer.parseInt(values[2])));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    public HashMap<String, Supervisor> getAllSupervisors() {
        return allSupervisors;
    }

    private static void loadSupervisors() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(System.getProperty("user.dir")
                + "/src/uk/ac/ncl/assessment/data/supervisors.csv"));) {
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(",");
                allSupervisors.put(values[2], Supervisor.getInstance(values[0], values[1], values[2]));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    private void checkValidStudentId(StudentId studentId) throws Exception {
        if(studentId == null) {
            throw new Exception("Invalid Student Id");
        } else if(!allStudents.containsKey(studentId.toString())) {
            throw new Exception("Student Id does not exist");
        }
    }

    private void checkValidStudent(Student student, Boolean existingStudent) throws Exception {
        if(student == null) {
            throw new Exception("Invalid Student Data");
        } else if (existingStudent){
            AbstractStudent stud = (AbstractStudent) student;
            if(stud.getStudentId() == null || stud.getSmartCard() == null) {
                throw new Exception("Student Data without StudentId/SmartCard");
            }
        } else {
            AbstractStudent stud = (AbstractStudent) student;
            if(stud.getStudentId() != null || stud.getSmartCard() != null) {
                throw new Exception("Cannot register already existing student");
            }
        }
    }
}
