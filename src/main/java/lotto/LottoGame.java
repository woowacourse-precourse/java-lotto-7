package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private final Map<LottoResult, Integer> totalMatchCount = new HashMap<>();

    public LottoGame() {
        initializeMatchCount();
    }

    private void initializeMatchCount() {
        for (LottoResult result : LottoResult.values()) {
            totalMatchCount.put(result, 0);
        }
    }

    public void purchaseLotto(Lotto lotto) {
        purchasedLottos.add(lotto);
    }

    public void evaluateResults(Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatches(winningLotto);
            LottoResult result = LottoResult.fromMatchCount(matchCount, lotto.hasBonus(bonusNumber));
            totalMatchCount.put(result, totalMatchCount.get(result) + 1);
        }
    }

    public Map<LottoResult, Integer> getTotalMatchCount() {
        return totalMatchCount;
    }
}
