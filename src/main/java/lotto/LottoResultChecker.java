package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LottoResultChecker {
    private final Map<Prize, Integer> prizeCountMap = new HashMap<>();

    public LottoResultChecker() {
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }
    }

    public void checkLottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchingCount = (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
            Prize prize = Prize.valueOf(matchingCount, bonusMatch);
            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
            }
        }
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Map.Entry<Prize, Integer> entry : prizeCountMap.entrySet()) {
            totalPrize += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculateYield(int lottoPurchaseAmount) {
        return (double) calculateTotalPrize() / (lottoPurchaseAmount * Constants.LOTTO_PRICE) * 100;
    }

    public Map<Prize, Integer> getPrizeCountMap() {
        return prizeCountMap;
    }
}
