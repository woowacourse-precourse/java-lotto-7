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
        int prizeKey = 0;
        if (matchCount == FIRST_WINNER.getMatchCount()) {
            prizeKey = FIRST_WINNER.getRank();
            if (isBonusMatched) {
                prizeKey = SECOND_WINNER.getRank();
            }
        } else if (matchCount == THIRD_WINNER.getMatchCount()) {
            prizeKey = THIRD_WINNER.getRank();
        } else if (matchCount == FOURTH_WINNER.getMatchCount()) {
            prizeKey = FOURTH_WINNER.getRank();
        } else if (matchCount == FIFTH_WINNER.getMatchCount()) {
            prizeKey = FIFTH_WINNER.getRank();
        }
        if (prizeKey != 0) {
            prizeMatchResults.put(prizeKey, prizeMatchResults.getOrDefault(prizeKey, 0) + 1);
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
