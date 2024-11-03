package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultStatistics {
    public int totalEarnings = 0;
    public int totalExpense = 0;
    public Map<LottoResult, Integer> resultCount = new HashMap<>();

    public LottoResultStatistics() {
        for (LottoResult result : LottoResult.values()) {
            resultCount.put(result, 0);
        }
    }

    public void analyze(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = lotto.lottoNumbers().contains(bonusNumber);
            LottoResult result = determineResult(matchCount, bonusMatch);
            updateStatistics(result);
        }
    }

    public LottoResult determineResult(int matchCount, boolean bonusMatch) {
        if (matchCount == LottoResult.SIX_NUMBER_MATCH.lottoMatchCount()) return LottoResult.SIX_NUMBER_MATCH;
        if (LottoResult.isBonusMatch(matchCount, bonusMatch)) return LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH;
        if (matchCount == LottoResult.FIVE_NUMBER_MATCH.lottoMatchCount()) return LottoResult.FIVE_NUMBER_MATCH;
        if (matchCount == LottoResult.FOUR_NUMBER_MATCH.lottoMatchCount()) return LottoResult.FOUR_NUMBER_MATCH;
        if (matchCount == LottoResult.THREE_NUMBER_MATCH.lottoMatchCount()) return LottoResult.THREE_NUMBER_MATCH;
        return null;
    }

    public void calculateTotalEarnings(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = lotto.lottoNumbers().contains(bonusNumber);
            LottoResult result = determineResult(matchCount, bonusMatch);
            if (result != null) {
                totalEarnings += result.lottoPrize();
            }
        }
    }

    public void updateStatistics(LottoResult result) {
        if (result != null) {
            resultCount.put(result, resultCount.get(result) + 1);
        }
    }

    public double calculateProfitRate() {
        return totalExpense == 0 ? 0 : (double) totalEarnings / totalExpense * 100;
    }

    public int getResultCount(LottoResult result) {
        return resultCount.getOrDefault(result, 0);
    }

    public void setTotalExpense(int amount) {
        this.totalExpense = amount;
    }
}
