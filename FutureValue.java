// The FutureValue class represents the future value attribute. The class has a getFutureValue(), which will return
// the future of value of user given investment, number of years, and annual interest rate. Appropriate data fields,
// constructors, setters, and getters are defined.

public class FutureValue {
    private int investmentAmount;
    private int numYears;
    private double annualInterestRate;
    private double futureValue;

    // Parametrized constructor that passes in the investment amount, the number of years, and annual interest rate.
    public FutureValue(int investmentAmount, int numYears, double annualInterestRate) {
        this.investmentAmount = investmentAmount;
        this.numYears = numYears;
        this.annualInterestRate = annualInterestRate;
    }

    // Setter method that updates the investment amount attribute.
    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    // Setter method that updates the number of years attribute.
    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

    // Setter method that updates the annual interest rate attribute.
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // Setter method that updates the future value attribute.
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

    // Getter method that reads the investment amount attribute.
    public int getInvestmentAmount() {
        return investmentAmount;
    }

    // Getter method that reads the number of years attribute.
    public int getNumYears() {
        return numYears;
    }

    // Getter method that reads the annual interest rate attribute.
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // The getFutureValue() method will calculate the future value using the formula: FV = P * ( 1 + i/12 )^12*n,
    // where i = annual interest rate, P = initial investment amount, n = number of years. For example, if the annual
    // interest rate is 3.25 percent, the number of years is 4 years, and the initial investment is $10,000:
    // i = .0325 n = 12*4 = 48 P = 10000 FV = 11386.28.
    public double getFutureValue() {
        annualInterestRate /= 100;
        futureValue = investmentAmount * Math.pow(1 + (annualInterestRate / 12), 12 * numYears);
        return futureValue;
    }
}