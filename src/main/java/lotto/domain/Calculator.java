package lotto.domain;

import java.util.Map;
import lotto.messages.WinningMessage;

public class Calculator {

    public static long winningAmountSum(Map<WinningMessage, Integer> winningResult) {
        return winningResult.keySet().stream()
                .mapToLong(rank -> rank.getWinningAmount(winningResult.get(rank)))
                .sum();
    }

    public static double calculateProfitPercent(long totalWinningMoney, int purchaseAmount) {
        return (totalWinningMoney / (double) purchaseAmount) / 10.0;
    }
}