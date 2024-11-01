package lotto.utility;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class LottoComparison {

    public static LottoRank compareLottoNumbers(List<Integer> winningNumbers, int bonusNumber, List<Integer> userLottoNumbers) {
        int matchCount = (int) userLottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonusNumber = userLottoNumbers.contains(bonusNumber);

        return determineRank(matchCount, hasBonusNumber);
    }

    private static LottoRank determineRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchCount == 5 && hasBonusNumber) {
            return LottoRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }
    public static double calculateProfitRate(Map<LottoRank, Integer> rankCounts, int purchaseAmount) {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 100.0) / 100.0;
    }
}

