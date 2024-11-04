package lotto.service;

import java.util.List;

public class ProfitCalculator {

    private static final int THREE_MATCH_PRIZE = 5000;
    private static final int FOUR_MATCH_PRIZE = 50000;
    private static final int FIVE_MATCH_PRIZE = 1500000;
    private static final int FIVE_MATCH_BONUS_PRIZE = 30000000;
    private static final int SIX_MATCH_PRIZE = 2000000000;

    public String calculateProfitRate(List<Integer> result, int amount) {
        double profit = THREE_MATCH_PRIZE * result.get(0) +
                FOUR_MATCH_PRIZE * result.get(1) +
                FIVE_MATCH_PRIZE * result.get(2) +
                FIVE_MATCH_BONUS_PRIZE * result.get(3) +
                SIX_MATCH_PRIZE * result.get(4);

        if(profit == 0) {
            return "0.0";
        }

        profit = profit / amount * 100;
        return String.format("%.1f", profit);
    }
}
