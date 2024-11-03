package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultStatistics {
    private int totalEarnings = 0;
    private int totalExpense = 0;
    private Map<LottoResult, Integer> resultCount = new HashMap<>();
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

    private LottoResult determineResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return LottoResult.SIX_NUMBER_MATCH;
        if (matchCount == 5 && bonusMatch) return LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH;
        if (matchCount == 5) return LottoResult.FIVE_NUMBER_MATCH;
        if (matchCount == 4) return LottoResult.FOUR_NUMBER_MATCH;
        if (matchCount == 3) return LottoResult.THREE_NUMBER_MATCH;
        return null;
    }

    private void updateStatistics(LottoResult result) {
        if (result != null) {
            resultCount.put(result, resultCount.get(result) + 1);
            totalEarnings += result.lottoPrize();
        }
    }

    public double calculateProfitRate() {
        if (totalExpense == 0) {
            return 0;
        } else {
            return (double) totalEarnings / totalExpense * 100;
        }
    }

    public int getResultCount(LottoResult result) {
        return resultCount.getOrDefault(result, 0);
    }

    public void setTotalExpense(int amount) {
        this.totalExpense = amount;
    }

}
