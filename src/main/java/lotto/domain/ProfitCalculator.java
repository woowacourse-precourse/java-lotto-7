package lotto.domain;

public class ProfitCalculator {

    private final int LOTTO_PRICE_PER_TICKET = 1000;
    private final int PERCENTAGE_MULTIPLIER = 100;

    public String calculateProfit(int prizeSum, int numberOfTickets) {
        double profit = ((double) prizeSum / (numberOfTickets * LOTTO_PRICE_PER_TICKET)) * PERCENTAGE_MULTIPLIER;

        return String.format("%.1f", profit);
    }
}
