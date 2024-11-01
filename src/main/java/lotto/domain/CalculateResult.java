package lotto.domain;

import java.util.List;
import lotto.util.PrizeType;

public class CalculateResult {
    public int[] calculateStatistics(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> lottoNumbers) {
        int[] results = new int[PrizeType.values().length];

        for (List<Integer> singleLotto : lottoNumbers) {
            int matchCount = countMatchingNumbers(singleLotto, winningNumbers);
            boolean hasBonus = singleLotto.contains(bonusNumber);

            if (matchCount == 6) {
                results[PrizeType.MATCHING_6.ordinal()]++;
            } else if (matchCount == 5 && hasBonus) {
                results[PrizeType.HAS_BONUS_WIN_MATCHING_5.ordinal()]++;
            } else if (matchCount == 5) {
                results[PrizeType.MATCHING_5.ordinal()]++;
            } else if (matchCount == 4) {
                results[PrizeType.MATCHING_4.ordinal()]++;
            } else if (matchCount == 3) {
                results[PrizeType.MATCHING_3.ordinal()]++;
            }
        }
        return results;
    }

    private int countMatchingNumbers(List<Integer> singleLotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : singleLotto) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
