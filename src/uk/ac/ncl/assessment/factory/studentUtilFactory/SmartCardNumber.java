package uk.ac.ncl.assessment.factory.studentUtilFactory;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;

public final class SmartCardNumber {
    private final String smartCardNumber;
    private final static HashSet<String> allSmartCardNumbers = new HashSet<String>();
    private SmartCardNumber(String smartCardNumber) {
        this.smartCardNumber = smartCardNumber;
    }
    public static SmartCardNumber getInstance(String firstName, String lastName) {
        Random rand = new Random();
        String smartCardNumber = String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0));
        smartCardNumber += "-" + Calendar.getInstance().get(Calendar.YEAR);
        smartCardNumber += "-" + rand.nextInt(100);
        if(!allSmartCardNumbers.contains(smartCardNumber)) {
            allSmartCardNumbers.add(smartCardNumber);
        } else {
            System.err.println("Smart Card Number already exists");
        }
        return new SmartCardNumber(smartCardNumber);
    }

    @Override
    public String toString() {
        return this.smartCardNumber;
    }
}
