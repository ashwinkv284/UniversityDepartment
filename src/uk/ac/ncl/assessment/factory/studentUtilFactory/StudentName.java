package uk.ac.ncl.assessment.factory.studentUtilFactory;

public final class StudentName {
    private final String firstName;
    private final String lastName;

    public StudentName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
