package lotto.domain.WinningLotto;

import java.text.NumberFormat;

public enum WinningLottoInfo {
    NO_MATCH(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchedCount;
    private final int prize;
    private int count;

    WinningLottoInfo(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.count = 0;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public String getFormattedPrize() {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(prize);
    }

    public void incrementCount() {
        count++;
    }

    public static WinningLottoInfo from(int matchedCount, boolean hasBonus) {
        if (matchedCount == 6) {
            return SIX_MATCH;
        }
        if (matchedCount == 5) {
            return hasBonus ? FIVE_MATCH_BONUS : FIVE_MATCH;
        }
        if (matchedCount == 4) {
            return FOUR_MATCH;
        }
        if (matchedCount == 3) {
            return THREE_MATCH;
        }
        return NO_MATCH;
    }
}
