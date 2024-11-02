package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private static final int FIRST_PRIZE_MATCH_COUNT = 6;
    private static final int SECOND_PRIZE_MATCH_COUNT = 5;
    private static final int THIRD_PRIZE_MATCH_COUNT = 5;
    private static final int FOURTH_PRIZE_MATCH_COUNT = 4;
    private static final int FIFTH_PRIZE_MATCH_COUNT = 3;

    public static Map<String, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> resultCounts = initializeResultCounts();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            updateResultCounts(resultCounts, matchCount, bonusMatch);
        }

        return resultCounts;
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static void updateResultCounts(Map<String, Integer> resultCounts, int matchCount, boolean bonusMatch) {
        if (matchCount == FIRST_PRIZE_MATCH_COUNT) {
            resultCounts.put("1등", resultCounts.get("1등") + 1);
        } else if (matchCount == SECOND_PRIZE_MATCH_COUNT && bonusMatch) {
            resultCounts.put("2등", resultCounts.get("2등") + 1);
        } else if (matchCount == THIRD_PRIZE_MATCH_COUNT) {
            resultCounts.put("3등", resultCounts.get("3등") + 1);
        } else if (matchCount == FOURTH_PRIZE_MATCH_COUNT) {
            resultCounts.put("4등", resultCounts.get("4등") + 1);
        } else if (matchCount == FIFTH_PRIZE_MATCH_COUNT) {
            resultCounts.put("5등", resultCounts.get("5등") + 1);
        }
    }

    private static Map<String, Integer> initializeResultCounts() {
        Map<String, Integer> resultCounts = new HashMap<>();
        resultCounts.put("1등", 0);
        resultCounts.put("2등", 0);
        resultCounts.put("3등", 0);
        resultCounts.put("4등", 0);
        resultCounts.put("5등", 0);
        return resultCounts;
    }
}

