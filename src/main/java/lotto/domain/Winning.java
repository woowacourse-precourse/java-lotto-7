package lotto.domain;

import java.text.NumberFormat;
import java.util.Locale;

public enum Winning {
    NONE(0, 0),
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_WITH_BONUS(7, 30_000_000),
    SIXTH(6, 2_000_000_000);

    private final int label;
    private final int winnings;

    Winning(int label, int winnings) {
        this.label = label;
        this.winnings = winnings;
    }

    public int getLabel() {
        return label;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Winning fromMatchCount(int matchCount) {
        for (Winning winning : Winning.values()) {
            if (matchCount == winning.label) {
                return winning;
            }
        }
        return Winning.NONE;
    }

    public String getFormattedWinnings() {
        return NumberFormat.getInstance(Locale.KOREA).format(winnings);
    }
}
