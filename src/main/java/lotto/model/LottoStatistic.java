package lotto.model;

import java.util.EnumMap;
import lotto.MatchType;

public class LottoStatistic {
    private static final int INITIAL_SETTING = 0;
    private static final int INCREMENT_BY_ONE = 1;
    private final EnumMap<MatchType, Integer> statistics = new EnumMap<>(MatchType.class);

    public LottoStatistic() {
        for (MatchType type : MatchType.values()) {
            statistics.put(type, INITIAL_SETTING);
        }
    }

    public void update(MatchType type) {
        statistics.put(type, statistics.get(type) + INCREMENT_BY_ONE);
    }

    public int calculateScore() {
        int total = 0;
        for (MatchType type : MatchType.values()) {
            total += statistics.get(type) * type.getPrise();
        }
        return total;
    }
}
