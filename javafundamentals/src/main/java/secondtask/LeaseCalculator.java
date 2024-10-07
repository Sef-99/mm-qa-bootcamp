package secondtask;

public class LeaseCalculator {
    private final int totalLeasedMoney;
    private final int downPayment;
    private final int leaseTerm;
    private final double interestRate;
    private final double monthlyPayment;

    public LeaseCalculator(int totalLeasedMoney, int downPayment, int leaseTerm, double interestRate) {
        if (totalLeasedMoney <= 0) {
            throw new IllegalArgumentException("Total leased money must be greater than 0.");
        }
        if (downPayment < 0 || downPayment > totalLeasedMoney) {
            throw new IllegalArgumentException("Down payment must be between 0 and total leased money.");
        }
        if (leaseTerm <= 0) {
            throw new IllegalArgumentException("Lease term must be greater than 0.");
        }
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }

        this.totalLeasedMoney = totalLeasedMoney;
        this.downPayment = downPayment;
        this.leaseTerm = leaseTerm;
        this.interestRate = interestRate;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    private double calculateMonthlyPayment() {
        double principal = totalLeasedMoney - downPayment;
        double interest = principal * (interestRate / 100);
        return (principal + interest) / leaseTerm;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }
}
