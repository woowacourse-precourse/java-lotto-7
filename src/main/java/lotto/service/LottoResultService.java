package lotto.service;

import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    private static final int FIRST_PLACE_MATCH_COUNT = 6;
    private static final int SECOND_PLACE_MATCH_COUNT = 5;
    private static final int THIRD_PLACE_MATCH_COUNT = 4;
    private static final int FOURTH_PLACE_MATCH_COUNT = 3;

    private static final int FIRST_PLACE_PRIZE = 2_000_000_000; // 1등: 6개 일치
    private static final int SECOND_PLACE_PRIZE = 30_000_000;   // 2등: 5개 + 보너스 번호
    private static final int THIRD_PLACE_PRIZE = 1_500_000;     // 3등: 5개 일치
    private static final int FOURTH_PLACE_PRIZE = 50_000;       // 4등: 4개 일치
    private static final int FIFTH_PLACE_PRIZE = 5_000;         // 5등: 3개 일치

    private static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            FIRST_PLACE_MATCH_COUNT, FIRST_PLACE_PRIZE,
            SECOND_PLACE_MATCH_COUNT, THIRD_PLACE_PRIZE, // 3등으로 설정 (5개 일치)
            THIRD_PLACE_MATCH_COUNT, FOURTH_PLACE_PRIZE,
            FOURTH_PLACE_MATCH_COUNT, FIFTH_PLACE_PRIZE
    );

    public Map<Integer, Integer> calculateWinningResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> resultCount = new HashMap<>();

        // 초기화 (등수별 카운트)
        for (int i = 3; i <= 6; i++) {
            resultCount.put(i, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber);

            // 2등 처리 (5개 + 보너스 번호)
            if (matchCount == 5 && isBonusMatched) {
                resultCount.put(5, resultCount.get(5) + 1); // 2등: 보너스 번호 포함
            } else if (matchCount >= 3) {
                resultCount.put(matchCount, resultCount.get(matchCount) + 1);
            }
        }

        return resultCount;
    }

    public int calculateTotalPrize(Map<Integer, Integer> resultCount) {
        int totalPrize = 0;
        for (Map.Entry<Integer, Integer> entry : resultCount.entrySet()) {
            int matchCount = entry.getKey();
            int count = entry.getValue();
            totalPrize += count * PRIZE_MONEY.getOrDefault(matchCount, 0);
        }
        return totalPrize;
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
