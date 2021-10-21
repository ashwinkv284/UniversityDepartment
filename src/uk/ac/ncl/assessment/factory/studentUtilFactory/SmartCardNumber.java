package uk.ac.ncl.assessment.factory.studentUtilFactory;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;

public final class SmartCardNumber {
    private final String smartCardNumber;
    private final static HashSet<String> allSmartCardNumbers = new HashSet<String>();
    /**
     * Returns instance of the class
     *
     * @param smartCardNumber    - smartCardNumber
     */
    private SmartCardNumber(String smartCardNumber) {
        this.smartCardNumber = smartCardNumber;
    }
    /**
     * Returns instance of the class
     *
     * @param firstName   - firstName of student
     * @param lastName    - lastName of student
     * @return            - instance of class
     */
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
    /**
     * Returns smartCardNumber
     *
     * @return - String
     */
    public String getSmartCardNumber() {
        return this.smartCardNumber;
    }
    /**
     * Returns string version of object
     *
     * @return - String
     */
    @Override
    public String toString() {
        return this.smartCardNumber;
    }
    /**
     * Checks if the two objects of the same class are equal
     *
     * @return boolean - true if equal, false if not equal
     */
    @Override
    public boolean equals(Object scNo) {
        if(scNo instanceof SmartCardNumber) {
            SmartCardNumber smartCardNo = (SmartCardNumber) scNo;
            return this.getSmartCardNumber().equals(smartCardNo.getSmartCardNumber());
        }
        return false;
    }
    /**
     * Generates hashCode for the object
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + (this.getSmartCardNumber() == null ? 0 : this.getSmartCardNumber().hashCode());
        return hc;
    }
}
