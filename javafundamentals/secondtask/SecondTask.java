package javafundamentals.secondtask;

import java.util.Scanner;

public class SecondTask {
    private static int totalLeasedMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Monthly Payment Calculator of leases!");

        do {
            LeaseCalculator leaseCalculator = gatherLeaseInputs(scanner);
            System.out.println("The monthly payment is: " + leaseCalculator.getMonthlyPayment());
            System.out.println("Do you want to continue? Yes/No");
        } while (doesUserContinue(scanner));
    }

    private static LeaseCalculator gatherLeaseInputs(Scanner scanner) {
        System.out.println("Please enter the Total Leased Money: ");
        totalLeasedMoney = getUserIntInput(scanner, "money");

        System.out.println("Please enter the Down Payment: ");
        int downPayment = getUserIntInput(scanner, "downPayment");

        System.out.println("Please enter the Lease Term (in months): ");
        int leaseTerm = getUserIntInput(scanner, "leaseTerm");

        System.out.println("Please enter the Interest Rate (in percentage): ");
        double interestRate = getUserDoubleInput(scanner);

        return new LeaseCalculator(totalLeasedMoney, downPayment, leaseTerm, interestRate);
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

    private static int getUserIntInput(Scanner scanner, String typeOfInput) {
        while (true) {
            String userInputRaw = scanner.nextLine().trim();

            if (userInputRaw.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid number.");
                continue;
            }

            try {
                int userInputProcessed = Integer.parseInt(userInputRaw);
                boolean isValid = switch (typeOfInput) {
                    case "money" -> isLeasedMoneyValid(userInputProcessed);
                    case "downPayment" -> isDownPaymentValid(userInputProcessed);
                    case "leaseTerm" -> isLeaseTermValid(userInputProcessed);
                    default -> {
                        System.out.println("Unexpected Value");
                        yield false;
                    }
                };

                if (isValid) {
                    return userInputProcessed;
                } else {
                    printErrorMessage(typeOfInput);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static double getUserDoubleInput(Scanner scanner) {
        while (true) {
            String userInputRaw = scanner.nextLine().trim();

            if (userInputRaw.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid number.");
                continue;
            }

            try {
                double userInputProcessed = Double.parseDouble(userInputRaw);

                if (isInterestRateValid(userInputProcessed)) {
                    return userInputProcessed;
                } else {
                    System.out.println("Interest rate should be a non-negative value!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }

    private static boolean isLeasedMoneyValid(int totalLeasedMoney) {
        return totalLeasedMoney > 0;
    }

    private static boolean isDownPaymentValid(int downPayment) {
        return downPayment >= 0 && downPayment <= totalLeasedMoney;
    }

    private static boolean isLeaseTermValid(int leaseTerm) {
        return leaseTerm > 0;
    }

    private static boolean isInterestRateValid(double interestRate) {
        return interestRate >= 0;
    }

    private static void printErrorMessage(String typeOfInput) {
        switch (typeOfInput) {
            case "money" -> System.out.println("Total leased money should be greater than 0!");
            case "downPayment" -> System.out.println("Down payment should be between 0 and " + totalLeasedMoney + "!");
            case "leaseTerm" -> System.out.println("Lease term should be a positive number greater than 0!");
            default -> System.out.println("Unknown error.");
        }
    }
}
