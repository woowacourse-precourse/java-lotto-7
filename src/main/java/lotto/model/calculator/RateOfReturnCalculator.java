package lotto.model.calculator;

public class RateOfReturnCalculator {

    private static final int UNIT_PRICE = 1_000;
    private static final int PERCENT = 100;

    public double calculate(int totalTickets, double totalPrize) {
        double totalSpent = totalTickets * UNIT_PRICE;

        return (totalPrize / totalSpent) * PERCENT;
    }

}
