// Main application class - contains the entry point for the program
public class App {
    
    // Main method - this is where the Java program starts executing
    // 'public' means it can be called from anywhere
    // 'static' means it belongs to the class, not an instance
    // 'void' means it doesn't return any value
    // 'throws Exception' allows the method to pass exceptions up the call stack
    public static void main(String[] args) throws Exception {
        
        // ===== CREATE NEW EMAIL OBJECT =====
        // Create an instance of the 'email' class
        // Pass "John" as the first name and "Smith" as the last name to the constructor
        // Store the reference to this new object in variable 'em1'
        email em1 = new email("John", "Smith");

        // ===== DISPLAY EMAIL INFORMATION =====
        // Call the showInfo() method on the em1 object
        // This method presumably returns a String with email details
        // Print that String to the console
        System.out.println(em1.showInfo());
    }
}
```

## **What This Program Does:**

This is a simple test/driver program that:

1. **Creates an email object** for a person named "John Smith"
2. **Displays information** about that email (likely shows the generated email address and other details)

## **Expected Output (based on typical email class structure):**

Depending on how your `email` class is implemented, the output might look something like:
```
Name: John Smith
Email: john.smith@company.com
Department: [department]
Password: [generated password]
```

## **Program Structure:**
```
App.java (this file)
    ├── Creates email object
    └── Displays email info

email.java (separate class file - not shown)
    ├── Constructor: email(String firstName, String lastName)
    ├── Fields: firstName, lastName, emailAddress, password, etc.
    └── Method: showInfo() - returns formatted string with email details
