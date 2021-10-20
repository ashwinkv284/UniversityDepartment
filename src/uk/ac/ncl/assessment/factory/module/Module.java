package uk.ac.ncl.assessment.factory.module;

import java.util.HashSet;

public final class Module {
    private final String code;
    private final String name;
    private final int credits;
    private final static HashSet<String> modules = new HashSet<String>();

    private Module(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public static Module getInstance(String code, String name, int credits) {
        if(!modules.contains(code+name+credits)) {
            modules.add(code+name+credits);
        } else {
            System.err.println("Module already exists");
        }
        return new Module(code, name, credits);
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public int getCredits() {
        return this.credits;
    }

    @Override
    public String toString() {
        return this.getCode() + "," + this.getName() + "," + this.getCredits();
    }
}
