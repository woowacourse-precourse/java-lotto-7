package lotto.Model;

import java.util.Map;

public class EarningRate {

    public static double returnEarningRate(int gameNumber, Map<Ranking,Integer> resultSet) {
        int purchaseAmount = gameNumber*1000;
        int earnedAmount = resultSet.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningPrize() * entry.getValue())
                .sum();
        return (double) earnedAmount /purchaseAmount;
    }
}
