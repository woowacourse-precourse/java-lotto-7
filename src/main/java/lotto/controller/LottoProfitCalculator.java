package lotto.controller;

import static lotto.domain.Constants.LOTTO_PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.view.Output;

public class LottoProfitCalculator {
    Ranking ranking;
    Output output = new Output();

    private Map<Ranking, Integer> rankingCounts = new HashMap<>();

    public void checkLotto(List<Lotto> issuedLotto, List<Integer> winningNumbers, int bonusNumber) {
        for (Ranking rank : Ranking.values()) {
            rankingCounts.put(rank, 0);
        }

        for (Lotto lotto : issuedLotto) {
            List<Integer> matchList = lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .toList();

            int matchCount = matchList.size();
            boolean isBonous = lotto.getNumbers().contains(bonusNumber);
            calculateRank(matchCount, isBonous);
        }
        int totalSpent = issuedLotto.size() * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();
        output.result(rankingCounts, totalSpent, totalPrize);
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (Map.Entry<Ranking, Integer> entry : rankingCounts.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    private void calculateRank(int matchCount, boolean isBonous) {
        Ranking rank = ranking.getRank(matchCount, isBonous);
        if (rank != null) {
            rankingCounts.put(rank, rankingCounts.get(rank) + 1);
        }
    }

}


