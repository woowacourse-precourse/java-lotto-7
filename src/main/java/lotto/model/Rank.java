package lotto.model;

import java.text.NumberFormat;
import java.util.Locale;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchNumberCount;
    private final boolean matchBonusNumber;
    private final int prize;

    Rank(int matchNumberCount, boolean matchBonusNumber, int prize) {
        this.matchNumberCount = matchNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prize = prize;
    }

    public static Rank decideRank(int matchNumberCount, boolean matchBonusNumber) {
        if (matchNumberCount == 6) {
            return FIRST;
        }
        if (matchNumberCount == 5 && matchBonusNumber) {
            return SECOND;
        }
        if (matchNumberCount == 5) {
            return THIRD;
        }
        if (matchNumberCount == 4) {
            return FOURTH;
        }
        if (matchNumberCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        NumberFormat prizeFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return prizeFormat.format(prize);
    }

}
