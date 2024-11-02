package lotto.model;

import java.util.List;
import lotto.constants.PrizeType;

public class LottoStatisticsCalculator {
    private final int MATCHING_6 = 6;
    private final int MATCHING_5 = 5;
    private final int MATCHING_4 = 4;
    private final int MATCHING_3 = 3;

    public int[] calculateStatistics(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> lottoNumbers) {
        int[] results = new int[PrizeType.values().length];

        lottoNumbers.forEach(singleLotto -> {
            int matchCount = countMatchingNumbers(singleLotto, winningNumbers);
            boolean hasBonus = singleLotto.contains(bonusNumber);
            updateResultsBasedOnMatchCount(matchCount, results, hasBonus);
        });
        return results;
    }

    private void updateResultsBasedOnMatchCount(int matchCount, int[] results, boolean hasBonus) {
        if (matchCount == MATCHING_6) {
            results[PrizeType.PLACE_OF_1ST.ordinal()]++;
        } else if (matchCount == MATCHING_5 && hasBonus) {
            results[PrizeType.PLACE_OF_2ST.ordinal()]++;
        } else if (matchCount == MATCHING_5) {
            results[PrizeType.PLACE_OF_3ST.ordinal()]++;
        } else if (matchCount == MATCHING_4) {
            results[PrizeType.PLACE_OF_4ST.ordinal()]++;
        } else if (matchCount == MATCHING_3) {
            results[PrizeType.PLACE_OF_5ST.ordinal()]++;
        }
    }

    private int countMatchingNumbers(List<Integer> singleLotto, List<Integer> winningNumbers) {
        return (int) singleLotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}