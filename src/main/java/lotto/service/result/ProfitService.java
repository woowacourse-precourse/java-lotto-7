package lotto.service.result;

import java.util.Arrays;
import java.util.List;
import lotto.domain.User;

public class ProfitService {
    private final List<Integer> winnings = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);

    public double profitCalculator(User user, List<Integer> result) {
        int totalWinnings = totalWinningCalculate(result);
        return calculate(user, totalWinnings);
    }

    private double calculate(User user, int totalWinnings) {
        int totalInvestment = user.getMoney().getMoney();
        return ((double) totalWinnings / totalInvestment) * 100;
    }

    private int totalWinningCalculate(List<Integer> result) {
        int totalWinnings = 0;
        for(int i = 0; i < 5; i ++) {
            totalWinnings += winnings.get(i) * result.get(i);
        }
        return totalWinnings;
    }
}
