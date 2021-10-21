package uk.ac.ncl.assessment.factory.supervisor;

import java.util.HashSet;

public final class Supervisor {
    private final String firstName;
    private final String lastName;
    private final String email;
    private static final HashSet<String> allSupervisors = new HashSet<String>();
    /**
     * Returns instance of the class
     *
     * @param firstName    - firstName of supervisor: String
     * @param lastName     - lastname of supervisor: String
     * @param email        - email of supervisor: String
     */
    private Supervisor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    /**
     * Returns instance of the class
     *
     * @param firstName    - firstName of supervisor: String
     * @param lastName     - lastname of supervisor: String
     * @param email        - email of supervisor: String
     *
     * @return instance of class
     */
    public static Supervisor getInstance(String firstName, String lastName, String email) {
        if(!allSupervisors.contains(email)) {
            allSupervisors.add(email);
        } else {
            System.err.println("Supervisor already exists");
        }
        return new Supervisor(firstName, lastName, email);
    }
    /**
     * Returns firstName
     *
     * @return firstName of supervisor
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Returns lastName
     *
     * @return lastName of supervisor
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Returns email
     *
     * @return email of supervisor
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Returns string value of the class object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Name: " + this.getFirstName() + " " + this.getLastName() + ", " + "Email: " + this.getEmail();
    }
    /**
     * Checks if the two objects of the same class are equal
     *
     * @return boolean - true if equal, false if not equal
     */
    @Override
    public boolean equals(Object sVisor) {
        if(sVisor instanceof Supervisor) {
            Supervisor supervisor = (Supervisor) sVisor;
            return this.getEmail().equals(supervisor.getEmail());
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
        hc = 37 * hc + (this.getEmail() == null ? 0 : this.getEmail().hashCode());
        return hc;
    }
}
