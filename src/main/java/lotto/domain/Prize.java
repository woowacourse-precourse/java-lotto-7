package lotto.domain;

import java.util.Arrays;

public enum Prize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final int prize;


    Prize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) return FIVE_MATCH_WITH_BONUS;

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
