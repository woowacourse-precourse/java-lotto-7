package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean needBonus;
    private final int prize;
    private final String message;

    LottoRank(int matchCount, boolean needBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.needBonus = needBonus;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank calculate(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank != SECOND)
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        if (this == NONE) {
            return message;
        }
        return String.format("%s (%,d원)", message, prize);
    }
}