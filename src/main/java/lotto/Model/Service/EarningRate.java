package lotto.Model.Service;

import java.util.Map;
import lotto.Model.Ranking;

public class EarningRate {
    //수익률을 반환하는 메소드
    public static double returnEarningRate(int gameNumber, Map<Ranking, Integer> resultSet) {
        int purchaseAmount = gameNumber * 1000;
        int earnedAmount = resultSet.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningPrize() * entry.getValue())
                .sum();
        return (double) earnedAmount / purchaseAmount;
    }
}
