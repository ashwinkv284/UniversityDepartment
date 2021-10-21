package uk.ac.ncl.assessment.factory.studentUtilFactory;

import uk.ac.ncl.assessment.helper.Constants;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class SmartCard {
    private SmartCardNumber smartCardNumber;
    private final Date dateOfBirth;
    private final Date dateOfIssue;
    private Date dateOfExpiry;
    private static final Map<String, Integer> studentTypeToNoOfYearMap = new HashMap<String, Integer>(){{
        put(Constants.UG, 4);
        put(Constants.PGT, 1);
        put(Constants.PGR, 1);
    }};
    /**
     * Returns instance of the class
     *
     * @param dateOfBirth    - code of the module
     * @param dateOfIssue    - name of the module
     * @return               - Instance of class
     */
    private SmartCard(Date dateOfBirth, Date dateOfIssue) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
    }
    /**
     * Returns instance of the class
     *
     * @param firstName    - firstName of the student
     * @param lastName     - lastName of the student
     * @param dateOfBirth  - date of birth of the student
     * @param studentType  - type of student
     * @return             - Instance of class
     */
    public static SmartCard getInstance(String firstName, String lastName, Date dateOfBirth, String studentType) {
        Date today = new Date();
        SmartCard sCard = new SmartCard(dateOfBirth, today);
        sCard.setSmartCardNumber(firstName, lastName);
        sCard.setSmartCardExpiry(studentType);
        return sCard;
    }
    /**
     * Sets expiry date of smart card based on the type of student
     * For UG Students, 4 years from the date of issue
     * For PG Students, 1 year from the date of issue
     *
     * @param studentType  - type of student
     */
    private void setSmartCardExpiry(String studentType) {
        Calendar c = Calendar.getInstance();
        c.setTime(this.dateOfIssue);
        c.add(Calendar.YEAR, studentTypeToNoOfYearMap.get(studentType));
        this.setExpiryDate(c.getTime());
    }
    /**
     * Returns smartCardNumber of the student
     *
     * @return - SmartCardNumber of the student
     */
    public SmartCardNumber getSmartCardNumber() {
        return smartCardNumber;
    }

    /**
     * Sets smartCardNumber of the student
     *
     * @param firstName    - firstName of the student
     * @param lastName     - lastName of the student
     */
    private void setSmartCardNumber(String firstName, String lastName) {
        this.smartCardNumber = SmartCardNumber.getInstance(firstName, lastName);
    }
    /**
     * Returns date of birth of the student
     *
     * @return - date of birth of the student
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Returns date of issue of smartcard
     *
     * @return - date of issue of smartcard
     */
    public Date getDateOfIssue() {
        return dateOfIssue;
    }
    /**
     * Returns expiry date of smartcard
     *
     * @return - expiry date of smartcard
     */
    public Date getExpiryDate() {
        return dateOfExpiry;
    }

    /**
     * Sets expiry date of smart card
     *
     * @param expiryDate  - date of expiry of smartCard computed from setSmartCardExpiry method
     */
    private void setExpiryDate(Date expiryDate) {
        this.dateOfExpiry = expiryDate;
    }
}
