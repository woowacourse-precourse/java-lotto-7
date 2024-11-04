package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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

    public void checkMatch(Lotto winingLotto, int bonusNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = 0;
            for (int number : lotto.getNumbers()) {
                matchCount = getMatchCount(winingLotto, number, matchCount);
            }
            boolean bonusMatched = lotto.getNumbers().contains(bonusNumber);
            MatchType matchType = getMatchType(matchCount, bonusMatched);
            updateNotNull(matchType);
        }
    }

    private void updateNotNull(MatchType matchType) {
        if (matchType != null) {
            update(matchType);
        }
    }

    private static int getMatchCount(Lotto winingLotto, int number, int matchCount) {
        if (winingLotto.getNumbers().contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    private MatchType getMatchType(int matchCount, boolean bonusMatched) {
        if (matchCount == 5 && bonusMatched) {
            return MatchType.FIVE_BONUS;
        }
        Map<Integer, MatchType> matchTypeMap = Map.of(
                6, MatchType.SIX_MATCHES,
                5, MatchType.FIVE_MATCHES,
                4, MatchType.FOUR_MATCHES,
                3, MatchType.THREE_MATCHES
        );
        return matchTypeMap.getOrDefault(matchCount, null);
    }

    public int calculateScore() {
        int total = 0;
        for (MatchType type : MatchType.values()) {
            total += statistics.get(type) * type.getPrise();
        }
        return total;
    }

    public EnumMap<MatchType, Integer> getStatistics() {
        return statistics;
    }
}
