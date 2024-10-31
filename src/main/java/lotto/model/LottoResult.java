package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultCount;

    public LottoResult(WinningNumbers winningNumbers, List<Lotto> purchasedLotto) {
        this.resultCount = calculateResults(winningNumbers, purchasedLotto);
    }

    private Map<Rank, Integer> calculateResults(WinningNumbers winningNumbers, List<Lotto> lottos) {
        Map<Rank, Integer> resultMap = initializeResultMap();
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto, winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            Rank rank = Rank.getRank(matchCount, hasBonus);
            resultMap.put(rank, resultMap.get(rank) + 1);
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

    private int calculateMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public Map<Rank, Integer> getResultCount() {
        return resultCount;
    }
}
