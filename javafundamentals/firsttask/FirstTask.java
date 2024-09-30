package javafundamentals.firsttask;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();

        System.out.println("Welcome to MentorMakers Corp's special record app!");
        System.out.println("Start entering the necessary employees' information when prompted.");
        System.out.println("Please, press enter when you are ready to start: ");
        scanner.nextLine();

        do {
            addEmployee(scanner, employeeList);
            System.out.println("Do you want to continue? Yes/No");
        } while (doesUserContinue(scanner));
        System.out.println();
        printEmployeeEmails(employeeList);
    }

    private static void printEmployeeEmails(LinkedList<Employee> employeeList) {
        System.out.println("Printing all employees' emails: ");
        for (Employee employee : employeeList) {
            String employeeEmail = employee.getEmail();
            System.out.println(employeeEmail);
        }
    }

    private static void addEmployee(Scanner scanner, LinkedList<Employee> employeeList) {
        System.out.println("Enter the Employee's first name: ");
        String firstName = getAndValidateName(scanner);
        System.out.println("Enter the Employee's last name: ");
        String lastName = getAndValidateName(scanner);
        System.out.println("Enter the Employee's age: ");
        int age = getAndValidateAge(scanner);
        System.out.println("Enter the new Employee's Number: ");
        System.out.printf("Range of Valid Employee Number is between %d and %d%n",
                Employee.LOWER_EMPLOYEE_NUMBER_LIMIT, Employee.UPPER_EMPLOYEE_NUMBER_LIMIT);
        int employeeNumber = getAndValidateEmployeeNumber(scanner);

        try {
            Employee newEmployee = new Employee(firstName, lastName, age, employeeNumber);
            employeeList.add(newEmployee);
            System.out.println("Employee added!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getAndValidateEmployeeNumber(Scanner scanner) {
        while (true) {
            try {
                int employeeNumber = scanner.nextInt();
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
                if (!(employeeNumber >= Employee.LOWER_EMPLOYEE_NUMBER_LIMIT
                        && employeeNumber <= Employee.UPPER_EMPLOYEE_NUMBER_LIMIT)) {
                    System.out.printf("The employee number is not valid." +
                                    " Please, enter a number between %d and %d.",
                            Employee.LOWER_EMPLOYEE_NUMBER_LIMIT,
                            Employee.UPPER_EMPLOYEE_NUMBER_LIMIT);
                    System.out.println();
                    continue;
                }
                if (!Employee.isEmployeeNumberFree(employeeNumber)) {
                    System.out.printf("The employee number is not free." +
                                    " Please, enter a number between %d and %d.",
                            Employee.LOWER_EMPLOYEE_NUMBER_LIMIT,
                            Employee.UPPER_EMPLOYEE_NUMBER_LIMIT);
                    System.out.println();
                    continue;
                }

                return employeeNumber;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static boolean doesUserContinue(Scanner scanner) {
        while (true) {
            String answer = scanner.nextLine().trim().toLowerCase();

            switch (answer) {
                case "yes", "y" -> {
                    return true;
                }
                case "no", "n" -> {
                    return false;
                }
                default -> System.out.println("Not a valid input. Please type 'Yes' or 'No'.");
            }
        }
    }

    private static int getAndValidateAge(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid age.");
                continue;
            }

            try {
                int employeeAge = Integer.parseInt(input);

                if (employeeAge >= 0 && employeeAge <= 100) {
                    return employeeAge;
                } else {
                    System.out.println("The age of the employee is not valid." +
                            " Please, enter an age between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }


    private static String getAndValidateName(Scanner scanner) {
        while (true) {
            String employeeName = scanner.nextLine().trim();
            if (employeeName.matches("[a-zA-Z]+")) {
                return employeeName;
            } else {
                if (employeeName.isEmpty()) {
                    System.out.println("Please, enter a name.");
                } else {
                    System.out.println("The name can only contain letters. Please, try again.");
                }
            }
        }
    }
}