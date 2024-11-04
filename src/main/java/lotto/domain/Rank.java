package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST_RANK(6, false, 2_000_000_000),
    SECOND_RANK(5, true, 30_000_000),
    THIRD_RANK(5, false, 1_500_000),
    FOURTH_RANK(4, false, 50_000),
    FIFTH_RANK(3, false, 5_000),
    NO_RANK(2, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank ->
                        rank.matchCount == matchCount && rank.bonusMatch == bonusMatch
                )
                .findFirst()
                .orElse(NO_RANK);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }
}
