package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<WinningType, Integer> lottoResult = new HashMap<>();

    public LottoResult(List<PurchaseLotto> purchaseLottos, Lotto winningLotto) {
        for (PurchaseLotto lotto : purchaseLottos) {
            int matchCount = calculateMatchCount(lotto.getLottoNumbers(), winningLotto.getNumbers());
            boolean bonusMatched = lotto.getLottoNumbers().contains(winningLotto.getBonusNumber());
            WinningType winningType = WinningType.valueOf(matchCount, bonusMatched);

            if (winningType != null) {
                lottoResult.put(winningType, lottoResult.getOrDefault(winningType, 0) + 1);
            }
        }
    }

    private int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int calculateTotalPrize() {
        return lottoResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<WinningType, Integer> getLottoResult() {
        return lottoResult;
    }
}