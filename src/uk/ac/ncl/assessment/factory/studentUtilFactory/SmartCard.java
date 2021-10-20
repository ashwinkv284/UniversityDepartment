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

    private SmartCard(Date dateOfBirth, Date dateOfIssue) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
    }

    public static SmartCard getInstance(String firstName, String lastName, Date dateOfBirth, String studentType) {
        Date today = new Date();
        SmartCard sCard = new SmartCard(dateOfBirth, today);
        sCard.setSmartCardNumber(firstName, lastName);
        sCard.setSmartCardExpiry(studentType);
        return sCard;
    }

    private void setSmartCardExpiry(String studentType) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, studentTypeToNoOfYearMap.get(studentType));
        this.setExpiryDate(c.getTime());
    }

    public SmartCardNumber getSmartCardNumber() {
        return smartCardNumber;
    }

    private void setSmartCardNumber(String firstName, String lastName) {
        this.smartCardNumber = SmartCardNumber.getInstance(firstName, lastName);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public Date getExpiryDate() {
        return dateOfExpiry;
    }

    private void setExpiryDate(Date expiryDate) {
        this.dateOfExpiry = expiryDate;
    }
}
