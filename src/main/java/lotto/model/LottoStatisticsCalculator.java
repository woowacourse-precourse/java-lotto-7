package lotto.model;

import java.util.List;
import lotto.constants.PrizeType;

public class LottoStatisticsCalculator {
    private final int PLACE_OF_1ST = 6;
    private final int PLACE_OF_2ST = 5;
    private final int PLACE_OF_3ST = 4;
    private final int PLACE_OF_4ST = 3;

    public int[] calculateStatistics(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> lottoNumbers) {
        int[] results = new int[PrizeType.values().length];

        lottoNumbers.forEach(singleLotto -> {
            int matchCount = countMatchingNumbers(singleLotto, winningNumbers);
            boolean hasBonus = singleLotto.contains(bonusNumber);

            if (matchCount == PLACE_OF_1ST) {
                results[PrizeType.MATCHING_6.ordinal()]++;
            } else if (matchCount == PLACE_OF_2ST && hasBonus) {
                results[PrizeType.HAS_BONUS_WIN_MATCHING_5.ordinal()]++;
            } else if (matchCount == PLACE_OF_2ST) {
                results[PrizeType.MATCHING_5.ordinal()]++;
            } else if (matchCount == PLACE_OF_3ST) {
                results[PrizeType.MATCHING_4.ordinal()]++;
            } else if (matchCount == PLACE_OF_4ST) {
                results[PrizeType.MATCHING_3.ordinal()]++;
            }
        });
        return results;
    }

    private int countMatchingNumbers(List<Integer> singleLotto, List<Integer> winningNumbers) {
        return (int) singleLotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}