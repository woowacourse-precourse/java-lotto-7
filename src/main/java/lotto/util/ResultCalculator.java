package lotto.util;

import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos, Lotto winningNumber, int bonus) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumber.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonus);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    public int getTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            int count = results.getOrDefault(rank, 0);
            totalPrize += rank.getWinningPrize() * count;
        }

        return totalPrize;
    }

    public double calculateProfit(int totalPrize, int amount) {
        return (double) totalPrize / amount * 100;
    }

    private int countMatches(List<Integer> lottos, List<Integer> winningNumber) {
        int count = 0;

        for (int number : lottos) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }

        return count;
    }
}
