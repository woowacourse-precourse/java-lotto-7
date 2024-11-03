package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultCountMap;

    public LottoResult(final WinningLotto winningLotto, final List<Lotto> purchasedLottos) {
        this.resultCountMap = calculateResults(winningLotto, purchasedLottos);
    }

    private Map<Rank, Integer> calculateResults(final WinningLotto winningLotto, final List<Lotto> purchasedLottos) {
        Map<Rank, Integer> resultMap = initializeResultMap();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = calculateMatchCount(lotto, winningLotto);
            boolean hasBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            Rank rank = Rank.getRank(matchCount, hasBonus);
            if (rank != null) resultMap.put(rank, resultMap.get(rank) + 1);
        }
        return resultMap;
    }

    private Map<Rank, Integer> initializeResultMap() {
        Map<Rank, Integer> resultMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
        return resultMap;
    }

    private int calculateMatchCount(final Lotto lotto, final WinningLotto winningLotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getWinningNumbers().getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public Map<Rank, Integer> getResultCountMap() {
        return resultCountMap;
    }
}
