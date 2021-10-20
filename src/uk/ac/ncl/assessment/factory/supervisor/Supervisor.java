package uk.ac.ncl.assessment.factory.supervisor;

import java.util.HashSet;

public final class Supervisor {
    private final String firstName;
    private final String lastName;
    private final String email;
    private static final HashSet<String> allSupervisors = new HashSet<String>();
    private Supervisor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static Supervisor getInstance(String firstName, String lastName, String email) {
        if(!allSupervisors.contains(email)) {
            allSupervisors.add(email);
        } else {
            System.err.println("Supervisor already exists");
        }
        return new Supervisor(firstName, lastName, email);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "Name: " + this.getFirstName() + " " + this.getLastName() + ", " + "Email: " + this.getEmail();
    }
}
