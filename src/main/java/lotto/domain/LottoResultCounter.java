package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCounter {
    public Map<Rank, Integer> countResults(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningNumbers, bonusNumber);
            results.put(rank, results.get(rank) + 1);
        }

        return results;
    }
}
