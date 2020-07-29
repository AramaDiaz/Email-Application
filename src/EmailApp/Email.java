package EmailApp;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String department;
    private String password;
    private int defaultPassLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private final String emailAddress;

    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Ask for department:
        this.department = setDepartment();
        System.out.println("New employee: " + getName());
        System.out.println("Department: " + this.department);
        if (department == "") {
            emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com";
        } else
            emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + ".company.com";
        System.out.println("Email created: " + emailAddress);
        // Set password:
        this.password = setPassword();
        System.out.println("Your password is: " + password);
    }

    private String setDepartment() {
        System.out.println("Enter department:\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        String department = "";
        switch (option) {
            case 1: department = "Sales";
            break;
            case 2: department = "Development";
            break;
            case 3: department = "Accounting";
            break;
            case 4: department = "";
        }
        return department;
    }

    private String setPassword () {
            // chose a Character random from this String
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(defaultPassLength);

            for (int i = 0; i < defaultPassLength; i++) {
                // generate a random number between 0 to AlphaNumericString variable length
                int index = (int)(AlphaNumericString.length() * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }
            this.password = sb.toString();
            return password;
    }

    public void changeDefaultPassLength() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new password length: ");
        this.defaultPassLength = sc.nextInt();
    }

    public String changePassword (String newPass) {
        return this.password = newPass;
    }

    public void setMailboxCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }

    public String defineAlternateEmail (String altEmail) {
        return this.alternateEmail = altEmail;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName () {
        return getFirstName() + " " + getLastName();
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "\nDisplay name: " + getName() +
                "\nCompany email: " + getEmailAddress() +
                "\nMailbox Capacity: " + getMailboxCapacity() + "mb" +
                "\nAlternate Email: " + getAlternateEmail();
    }
}
