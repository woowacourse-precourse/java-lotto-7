package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    public Map<Rank, Integer> calculateWinningResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> resultCount = new HashMap<>();

        // 초기화 (등수별 카운트)
        for (Rank rank : Rank.values()) {
            resultCount.put(rank, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber);

            Rank rank = determineRank(matchCount, isBonusMatched);
            if (rank != null) {
                resultCount.put(rank, resultCount.get(rank) + 1);
            }
        }

        return resultCount;
    }

    public int calculateTotalPrize(Map<Rank, Integer> resultCount) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : resultCount.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += count * rank.getPrize();
        }
        return totalPrize;
    }

    private Rank determineRank(int matchCount, boolean isBonusMatched) {
        if (matchCount == 6) {
            return Rank.FIRST;
        } else if (matchCount == 5 && isBonusMatched) {
            return Rank.SECOND;
        } else if (matchCount == 5) {
            return Rank.THIRD;
        } else if (matchCount == 4) {
            return Rank.FOURTH;
        } else if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return null;
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
