package lotto.utils;

import java.util.Arrays;
import java.util.List;
import lotto.domain.User;

public class ProfitCalculator {
    private static final List<Integer> winnings = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);

    public static double calculateProfit(User user, List<Integer> result) {
        int totalWinnings = totalWinningCalculate(result);
        return calculate(user, totalWinnings);
    }

    private static double calculate(User user, int totalWinnings) {
        int totalInvestment = user.getMoney().getMoney();
        return ((double) totalWinnings / totalInvestment) * 100;
    }

    private static int totalWinningCalculate(List<Integer> result) {
        int totalWinnings = 0;
        for (int i = 0; i < winnings.size(); i++) {
            totalWinnings += winnings.get(i) * result.get(i);
        }
        return totalWinnings;
    }
}
