package lotto.rank;

import static lotto.constants.CommonConstants.UNUSED;

import java.util.function.Predicate;

public enum Ranking {
    NONE(matchCount -> (matchCount <= 2), UNUSED, true, false, 0L),
    FIFTH(matchCount -> (matchCount == 3), 3, true, false, 5_000L),
    FOURTH(matchCount -> (matchCount == 4), 4, true, false, 50_000L),
    THIRD(matchCount -> (matchCount == 5), 5, false, false, 1_500_000L),
    SECOND(matchCount -> (matchCount == 5), 5, false, true, 30_000_000L),
    FIRST(matchCount -> (matchCount == 6), 6, true, false, 2_000_000_000L);

    private final Predicate<Integer> matchCountRule;
    private final int matchCount;
    private final boolean ignoreBonus;
    private final boolean matchBonus;
    private final long prize;

    Ranking(Predicate<Integer> matchCountRule, int matchCount, boolean ignoreBonus, boolean matchBonus, long prize) {
        this.matchCountRule = matchCountRule;
        this.matchCount = matchCount;
        this.ignoreBonus = ignoreBonus;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public Predicate<Integer> getMatchCountRule() {
        return matchCountRule;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public static Ranking valueOf(int actualMatchCount, boolean actualMatchBonus) {
        for (Ranking ranking : values()) {
            if (matchesCriteria(actualMatchCount, actualMatchBonus, ranking)) {
                return ranking;
            }
        }
        return Ranking.NONE;
    }

    private static boolean matchesCriteria(int actualMatchCount, boolean actualMatchBonus, Ranking ranking) {
        return ranking.getMatchCountRule().test(actualMatchCount) &&
                (ranking.ignoreBonus || ranking.matchBonus == actualMatchBonus);
    }
}
