package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(1, 2_000_000_000, 6, false),
    SECOND(2, 30_000_000, 5, true),
    THIRD(3, 1_500_000, 5, false),
    FOURTH(4, 50_000, 4, false),
    FIFTH(5, 5_000, 3, false),
    MISS(6, 0, 0, false);

    private final int grade;
    private final long prize;
    private final int matchCount;
    private final boolean isRequireMatchBonus;

    Ranking(int grade, int prize, int matchCount, boolean isRequireMatchBonus) {
        this.grade = grade;
        this.prize = prize;
        this.matchCount = matchCount;
        this.isRequireMatchBonus = isRequireMatchBonus;
    }

    public static Ranking findBy(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.match(matchCount, isMatchBonus))
                .min((rank1, rank2) -> Integer.compare(rank1.grade, rank2.grade))
                .orElse(MISS);
    }

    private boolean match(int matchCount, boolean isMatchBonus) {
        if (this.matchCount != matchCount) {
            return false;
        }

        if (isRequireMatchBonus) {
            return isMatchBonus;
        }

        return true;
    }

    public int getGrade() {
        return grade;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequireMatchBonus() {
        return isRequireMatchBonus;
    }
}
