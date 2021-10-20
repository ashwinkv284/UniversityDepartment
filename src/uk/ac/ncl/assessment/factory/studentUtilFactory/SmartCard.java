package uk.ac.ncl.assessment.factory.studentUtilFactory;

import java.util.Date;

public final class SmartCard {
    private SmartCardNumber smartCardNumber;
    private final Date dateOfBirth;
    private final Date dateOfIssue;
    private Date dateOfExpiry;

    private SmartCard(Date dateOfBirth, Date dateOfIssue) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
    }

    public static SmartCard getInstance(String firstName, String lastName, Date dateOfBirth) {
        Date today = new Date();
        SmartCard sCard = new SmartCard(dateOfBirth, today);
        sCard.setSmartCardNumber(firstName, lastName);
        return sCard;
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
