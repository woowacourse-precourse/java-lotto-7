package lotto.domain.winning;

import static lotto.resources.Constants.ZERO;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics;
    private int totalPrize = ZERO;

    private LottoStatistics(final Map<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public static LottoStatistics createLottoStatistics() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            statistics.put(rank, ZERO);
        }
        return new LottoStatistics(statistics);
    }

    public void addResult(Rank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
        totalPrize += rank.getPrize();
    }

    public Map<Rank, Integer> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
