package lotto.enums;

import java.util.Arrays;

public enum Rank {
    NONE(0,  0L, "미당첨"),
    FIFTH(3,  5_000L, "3개 일치"),
    FOURTH(4,  50_000L, "4개 일치"),
    THIRD(5,  1_500_000L, "5개 일치"),
    SECOND(5,  30_000_000L, "5개 일치, 보너스 볼 일치"),
    FIRST(6,  2_000_000_000L, "6개 일치");

    private final int matchCount;
    private final long prize;
    private final String description;

    Rank(int matchCount, long prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }


    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Rank determineRank(int matchCount, boolean bonusBall) {
        if (matchCount == 5 && bonusBall) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(NONE);
    }

}
