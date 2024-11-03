package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public static Map<PrizeRank, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> resultCounts = initializeResultCounts();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            PrizeRank rank = determinePrizeRank(matchCount, bonusMatch);
            if (rank != null) { resultCounts.put(rank, resultCounts.get(rank) + 1); }
        }

        return resultCounts;
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) { matchCount++; }
        }
        return matchCount;
    }

    private static PrizeRank determinePrizeRank(int matchCount, boolean bonusMatch) {
        if (matchCount == PrizeRank.FIRST.getMatchCount()) {
            return PrizeRank.FIRST;
        }
        if (matchCount == PrizeRank.SECOND.getMatchCount() && bonusMatch) {
            return PrizeRank.SECOND;
        }
        if (matchCount == PrizeRank.THIRD.getMatchCount()) {
            return PrizeRank.THIRD;
        }
        if (matchCount == PrizeRank.FOURTH.getMatchCount()) {
            return PrizeRank.FOURTH;
        }
        if (matchCount == PrizeRank.FIFTH.getMatchCount()) {
            return PrizeRank.FIFTH;
        }
        return null;
    }

    private static Map<PrizeRank, Integer> initializeResultCounts() {
        Map<PrizeRank, Integer> resultCounts = new HashMap<>();
        for (PrizeRank rank : PrizeRank.values()) {
            resultCounts.put(rank, 0);
        }
        return resultCounts;
    }
}
