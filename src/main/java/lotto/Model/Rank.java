package lotto.Model;

import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, false, 2000000000L, (matchCount, bonus) -> matchCount == 6),
    SECOND(5, true, 30000000L, (matchCount, bonus) -> matchCount == 5 && bonus),
    THIRD(5, false, 1500000L, (matchCount, bonus) -> matchCount == 5 && !bonus),
    FOURTH(4, false, 50000L, (matchCount, bonus) -> matchCount == 4),
    FIFTH(3, false, 5000L, (matchCount, bonus) -> matchCount == 3),
    NONE(0, false, 0L, (matchCount, bonus) -> matchCount < 3);

    private final int matchCount;
    private final boolean bonusMatch;
    private final Long prize;
    private final BiPredicate<Integer, Boolean> rankCriteria;

    Rank(int matchCount, boolean bonusMatch, Long prize, BiPredicate<Integer, Boolean> rankCriteria) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.rankCriteria = rankCriteria;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public Long getPrize() {
        return prize;
    }

    public boolean matchs(int matchCount, boolean bonusMatch) {
        return rankCriteria.test(matchCount, bonusMatch);
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchs(matchCount, bonusMatch)) {
                return rank;
            }
        }

        return NONE;
    }
}