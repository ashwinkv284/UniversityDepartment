package uk.ac.ncl.assessment.helper;

import uk.ac.ncl.assessment.factory.module.Module;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {
    public static int calculateAge(Date dateOfBirth) {
        Date today = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int birthDate = Integer.parseInt(formatter.format(dateOfBirth));
        int currentDate = Integer.parseInt(formatter.format(today));
        return (currentDate - birthDate) / 10000;
    }

    public static Boolean checkEnoughCredit(List<Module> modules, int numberOfCredits) {
        int totalCredits = 0;
        if (modules != null) {
            for (Module module : modules) {
                totalCredits += module.getCredits();
            }
        }
        return totalCredits == numberOfCredits;
    }
}

