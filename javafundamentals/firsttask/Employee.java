package javafundamentals.firsttask;

import java.util.ArrayList;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int employeeNumber;
    private final String email;

    public static final int LOWER_EMPLOYEE_NUMBER_LIMIT = 27560000;
    public static final int UPPER_EMPLOYEE_NUMBER_LIMIT = 27569999;
    private static final ArrayList<Integer> REGISTERED_EMPLOYEE_NUMBERS =
            new ArrayList<>(UPPER_EMPLOYEE_NUMBER_LIMIT - LOWER_EMPLOYEE_NUMBER_LIMIT);

    Employee(String firstName, String lastName, int age, int employeeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (age >= 0 && age <= 100) {
            this.age = age;
        } else {
            throw new RuntimeException("Invalid Employee Age. Should be between 0 and 100.");
        }
        if(isEmployeeNumberFree(employeeNumber)){
            this.employeeNumber = employeeNumber;
            REGISTERED_EMPLOYEE_NUMBERS.add(employeeNumber);
        } else {
            throw new RuntimeException("Invalid Employee Number. That number is already registered.");
        }
        this.email = String.format("%s.%s@mentormakers.com", firstName.toLowerCase(),
                lastName.toLowerCase());
    }

    public static boolean isEmployeeNumberFree(int employeeNumber) {
        return !REGISTERED_EMPLOYEE_NUMBERS.contains(employeeNumber);
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Employee #%d:
                        Employee Name: '%s %s'
                        Employee Age: %d
                        Employee Email: '%s'""",
                this.employeeNumber,
                this.firstName,
                this.lastName,
                this.age,
                this.email
        );
    }



}
