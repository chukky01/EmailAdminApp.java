import java.util.Scanner;

/**
 * Model class that represents a company e-mail account.
 * Stores personal data, generates a secure password, and builds
 * the final e-mail address in the form:
 * firstName.lastName@department.aeycompany.com
 */
public class email {

    /* =========  INSTANCE VARIABLES  ========= */
    private String firstName;          // Employee's first name
    private String lastName;           // Employee's last name
    private String password;           // Randomly generated login password
    private String department;         // Department chosen by user (Sales, Development, etc.)
    private String email;              // Final e-mail address we build
    private int mailBoxCapacity = 500; // Mailbox size in megabytes (default 500 MB)
    private int defaultPasswordLength = 10; // How long the auto-password should be
    private String alternateEmail;     // Optional alternate e-mail (user can set later)
    private String companySuffix = ".aeycompany.com"; // Domain part of e-mail

    /* =========  CONSTRUCTOR  ========= */
    /**
     * Receives first & last name, then:
     * 1. Prompts user for department
     * 2. Creates random password
     * 3. Builds and stores the company e-mail address
     */
    public email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Ask user which department they work in (returns string like "Sales")
        this.department = setDepartment();

        // Generate a secure random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine parts to create e-mail: firstName.lastName@department.aeycompany.com
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
    }

    /* =========  PRIVATE HELPER METHODS  ========= */

    /**
     * Interactively asks the user to pick a department via console input.
     * @return department name (Sales, Development, Accounting) or empty string if none.
     */
    private String setDepartment() {
        System.out.print("New Worker: " + firstName + " " + lastName + ".\n"
                + "DEPARTMENT CODES:\n"
                + "1 for Sales.\n2 for Development.\n3 for Accounting.\n0 for none.\n"
                + "Enter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice) {
            case 1:  return "Sales";
            case 2:  return "Development";
            case 3:  return "Accounting";
            default: return "";          // 0 or any other key → no department
        }
    }

    /**
     * Builds a random password from letters, digits and symbols.
     * @param length how many characters the password should contain
     * @return the generated password string
     */
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    /* =========  PUBLIC MUTATORS & ACCESSORS  ========= */

    public void setMailBoxCapacity(int capacity) {      // Change mailbox size
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {    // Set alternate e-mail
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {       // Allow password update
        this.password = password;
    }

    /* ---- getters ---- */
    public int    getMailBoxCapacity() { return mailBoxCapacity; }
    public String getAlternateEmail()  { return alternateEmail; }
    public String getPassword()        { return password; }

    /**
     * Returns a formatted summary of this e-mail account.
     * Used for display purposes.
     */
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX: " + mailBoxCapacity + "MB";
    }
}
