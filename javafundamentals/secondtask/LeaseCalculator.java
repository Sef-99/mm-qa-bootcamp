package javafundamentals.secondtask;

public class LeaseCalculator {
    private final int totalLeasedMoney;
    private final int downPayment;
    private final int leaseTerm;
    private final double interestRate;
    private final double monthlyPayment;

    public LeaseCalculator(int totalLeasedMoney, int downPayment, int leaseTerm, double interestRate) {
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
