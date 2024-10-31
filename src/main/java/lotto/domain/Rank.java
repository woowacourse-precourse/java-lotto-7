package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, false, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, false, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, false, "3개 일치 (5,000원)"),
    NONE(0, 0, false, "");

    private final int matchingCount;
    private final int prize;
    private final boolean hasBonusNumber;
    private final String message;

    Rank(int matchingCount, int prize, boolean hasBonusNumber, String message) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
        this.message = message;
    }

    public static Rank getWinnerPrize(int count, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == count)
                .filter(rank -> rank.hasBonusNumber == hasBonus)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}


