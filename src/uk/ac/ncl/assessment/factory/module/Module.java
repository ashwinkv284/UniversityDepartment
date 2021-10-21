package uk.ac.ncl.assessment.factory.module;

import java.util.HashSet;

public final class Module {
    private final String code;
    private final String name;
    private final int credits;
    private final static HashSet<String> modules = new HashSet<String>();
    /**
     * Returns instance of the class
     *
     * @param code    - code of the module
     * @param name    - name of the module
     * @param credits - credits allocated for the module
     */
    private Module(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    /**
     * Returns instance of the class
     *
     * @param code    - code of the module
     * @param name    - name of the module
     * @param credits - credits allocated for the module
     * @return        - Instance of class
     */
    public static Module getInstance(String code, String name, int credits) {
        if(!modules.contains(code+name+credits)) {
            modules.add(code+name+credits);
        } else {
            System.err.println("Module already exists");
        }
        return new Module(code, name, credits);
    }

    /**
     * Returns code of the module
     *
     * @return - module code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Returns name of the module
     *
     * @return - module name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns credits of the module
     *
     * @return - module credits
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * Returns string value of the object
     *
     * @return - String
     */
    @Override
    public String toString() {
        return this.getCode() + "," + this.getName() + "," + this.getCredits();
    }

    /**
     * Checks if the two objects of the same class are equal
     *
     * @return boolean - true if equal, false if not equal
     */
    @Override
    public boolean equals(Object mod) {
        if(mod instanceof Module) {
            Module module = (Module) mod;
            return this.getCode().equals(module.getCode());
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
        hc = 37 * hc + (this.getCode() == null ? 0 : this.getCode().hashCode());
        return hc;
    }
}
