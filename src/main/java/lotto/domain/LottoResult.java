package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;

    private LottoResult(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = new EnumMap<>(rankCounts);
    }

    public static LottoResult of(List<Lotto> lottos, WinningNumbers winningNumbers) {

        return new LottoResult(null);
    }

    public int getCountByRank(LottoRank rank) {
        return 0;
    }
}
