package lotto.domain;

import java.util.Arrays;

public enum Winning {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;

    Winning(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Winning valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_WITH_BONUS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }
}
