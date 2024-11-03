package lotto.model;

import java.text.NumberFormat;
import java.util.Locale;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000);

    private final int matchNumbersCount;
    private final int matchBonus;
    private final int prize;

    Rank(int matchNumbersCount, int matchBonus, int prize) {
        this.matchNumbersCount = matchNumbersCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchNumbersCount() {
        return matchNumbersCount;
    }

    public int getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        return formatter.format(prize);
    }
}
