package lotto.model;

import java.text.NumberFormat;
import java.util.Locale;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public String getFormattedPrize() {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(prize) + "원";
    }
}
