package lotto.rank;

import java.util.function.Predicate;

public enum Ranking {
    FIRST(matchCount -> (matchCount == 6), true, false, 2_000_000_000L),
    SECOND(matchCount -> (matchCount == 5), false, true, 30_000_000L),
    THIRD(matchCount -> (matchCount == 5), false, false, 1_500_000L),
    FOURTH(matchCount -> (matchCount == 4), true, false, 50_000L),
    FIFTH(matchCount -> (matchCount == 3), true, false, 5_000L),
    NONE(matchCount -> (matchCount <= 2), true, false, 0L);

    private final Predicate<Integer> matchCountRule;
    private final boolean ignoreBonus;
    private final boolean matchBonus;
    private final long prize;

    Ranking( Predicate<Integer> matchCountRule, boolean ignoreBonus, boolean matchBonus, long prize) {
        this.matchCountRule = matchCountRule;
        this.ignoreBonus = ignoreBonus;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public Predicate<Integer> getMatchCountRule() {
        return matchCountRule;
    }

    public boolean ignoreBonus() {
        return ignoreBonus;
    }

    public boolean matchBonus() {
        return matchBonus;
    }

    public long getPrize() {
        return prize;
    }

    public static Ranking valueOf(int matchCount, boolean bonusMatch) {
        for (Ranking ranking : values()) {
            if (matchesCriteria(matchCount, bonusMatch, ranking)) {
                return ranking;
            }
        }
        return Ranking.NONE;
    }

    private static boolean matchesCriteria(int matchCount, boolean bonusMatch, Ranking ranking) {
        return ranking.getMatchCountRule().test(matchCount) &&
                (ranking.ignoreBonus || ranking.matchBonus == bonusMatch);
    }
}
