package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinCheck {
    private final Set<Integer> winLotto;
    private final int bonusNumber;

    public LottoWinCheck(LottoWinNumbers winNumbers) {
        this.winLotto = new HashSet<>(winNumbers.lotto().numbers());
        this.bonusNumber = winNumbers.bonusNumber();
    }

    public Map<Integer, Integer> getWinResult(List<Lotto> lottos) {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Lotto lotto : lottos) {
            int duplicated = (int) lotto.numbers().stream()
                    .filter(winLotto::contains)
                    .count();

            boolean containBonus = lotto.numbers().contains(bonusNumber);
            int rank = getRankByDuplicated(duplicated, containBonus);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }

    private int getRankByDuplicated(int duplicated, boolean containBonus) {
        if (duplicated == 6) {
            return 1;
        }
        if (duplicated == 5 && containBonus) {
            return 2;
        }
        if (duplicated == 5) {
            return 3;
        }
        if (duplicated == 4) {
            return 4;
        }
        if (duplicated == 3) {
            return 5;
        }
        return -1;
    }
}
