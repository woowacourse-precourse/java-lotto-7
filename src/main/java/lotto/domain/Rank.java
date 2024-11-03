package lotto.domain;

import java.text.DecimalFormat;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "0개 일치");

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prize;
    private final String message;

    Rank(int matchCount, boolean isBonusMatch, int prize, String message) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prize = prize;
        this.message = message;
    }

    public static Rank valueOf(int matchCount, boolean isBonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.isBonusMatch == isBonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return " (" + decimalFormat.format(prize) + "원)";
    }

    public String getMessage() {
        return message;
    }
}
