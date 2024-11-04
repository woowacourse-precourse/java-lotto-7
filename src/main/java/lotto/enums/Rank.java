package lotto.enums;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 1, 2_000_000_000),
    SECOND(5, true, 2, 30_000_000),
    THIRD(5, false, 3, 1_500_000),
    FOURTH(4, false, 4, 50_000),
    FIFTH(3, false, 5, 5_000),
    NONE(0, false, 0, 0),
    ;

    private final int matchCount;
    private final boolean bonusNumberFlag;
    private final int rank;
    private final int prize;

    Rank(int matchCount, boolean bonusNumberFlag, int rank, int prize) {
        this.matchCount = matchCount;
        this.bonusNumberFlag = bonusNumberFlag;
        this.rank = rank;
        this.prize = prize;
    }

    public static int calculate(long matchCount, boolean bonusNumberFlag) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusNumberFlag == bonusNumberFlag)
                .findAny()
                .orElse(NONE)
                .getRank();
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}