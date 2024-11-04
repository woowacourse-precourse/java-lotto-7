package lotto.domain;

import static lotto.constants.NumberConstants.PERCENTAGE_MULTIPLIER;
import static lotto.constants.NumberConstants.LOTTO_PRICE_PER_TICKET;

public class ProfitCalculator {

    public String calculateProfit(int prizeSum, int numberOfTickets) {
        double profit = ((double) prizeSum / (numberOfTickets * LOTTO_PRICE_PER_TICKET))
                * PERCENTAGE_MULTIPLIER;

        return String.format("%.1f", profit);
    }
}
