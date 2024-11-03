package lotto.constant;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    public final int matchCount;
    public final int prize;


    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank getRank(int count, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == count && (!bonus || (bonus && rank == SECOND)))
                .findAny()
                .orElse(NONE);
    }
}
