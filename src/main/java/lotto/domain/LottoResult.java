package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.WINNERS;
import static lotto.constants.WinnerConstants.FIFTH_WINNER;
import static lotto.constants.WinnerConstants.FIRST_WINNER;
import static lotto.constants.WinnerConstants.FOURTH_WINNER;
import static lotto.constants.WinnerConstants.SECOND_WINNER;
import static lotto.constants.WinnerConstants.THIRD_WINNER;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeMatchResults;
    private final int count;

    public LottoResult(int count) {
        this.prizeMatchResults = new HashMap<>();
        this.count = count;
    }

    public void updateLottoResult(int matchCount, boolean isBonusMatched) {
        if (isBonusMatched) {
            matchCount++;
        }
        if (matchCount == FIRST_WINNER.getMatchCount()) {
            int key = FIRST_WINNER.getRank();
            if (isBonusMatched) {
                key = SECOND_WINNER.getRank();
            }
            prizeMatchResults.put(key, prizeMatchResults.getOrDefault(key, 0) + 1);
        } else if (matchCount == THIRD_WINNER.getMatchCount()) {
            prizeMatchResults.put(THIRD_WINNER.getRank(),
                    prizeMatchResults.getOrDefault(THIRD_WINNER.getRank(), 0) + 1);
        } else if (matchCount == FOURTH_WINNER.getMatchCount()) {
            prizeMatchResults.put(FOURTH_WINNER.getRank(),
                    prizeMatchResults.getOrDefault(FOURTH_WINNER.getRank(), 0) + 1);
        } else if (matchCount == FIFTH_WINNER.getMatchCount()) {
            prizeMatchResults.put(FIFTH_WINNER.getRank(),
                    prizeMatchResults.getOrDefault(FIFTH_WINNER.getRank(), 0) + 1);
        }
    }

    public double calculateRateOfReturn() {
        double totalRevenue = WINNERS.stream()
                .mapToDouble(winner -> prizeMatchResults.getOrDefault(winner.getRank(), 0) * winner.getPrizeMoney())
                .sum();

        int totalInvest = count * LOTTO_PRICE;
        double rateOfReturn = (totalRevenue / totalInvest) * 100;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }

    public Map<Integer, Integer> getPrizeMatchResults() {
        return prizeMatchResults;
    }
}
