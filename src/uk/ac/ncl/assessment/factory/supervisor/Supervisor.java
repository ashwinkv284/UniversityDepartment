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

    @Override
    public boolean equals(Object sVisor) {
        if(sVisor instanceof Supervisor) {
            Supervisor supervisor = (Supervisor) sVisor;
            return this.getEmail().equals(supervisor.getEmail());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + (this.getEmail() == null ? 0 : this.getEmail().hashCode());
        return hc;
    }
}
