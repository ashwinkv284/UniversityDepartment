package uk.ac.ncl.assessment.factory.studentUtilFactory;

public final class StudentName {
    private final String firstName;
    private final String lastName;
    /**
     * Returns instance of the class
     *
     * @param firstName    - firstName of student
     * @param lastName     - lastname of student
     */
    public StudentName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * Returns firstName
     *
     * @return - String - firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Returns firstName
     *
     * @return - String - lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns fullName in String
     *
     * @return - String
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
