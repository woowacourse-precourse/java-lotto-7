package lotto.eunm;

import java.text.NumberFormat;
import java.util.Locale;

public enum WinningResult {
    THREE(3, 3, 5_000),
    FOUR(4, 4, 50_000),
    FIVE(5, 5, 1_500_000),
    FIVE_AND_BONUS(6, 5, 30_000_000),
    SIX(7, 6, 2_000_000_000);

    public final int index;
    public final int winningCount;
    public final int prizeMoney;

    WinningResult(int index, int matchCount, int prizeMoney) {
        this.index = index;
        this.winningCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public String getFormattedPrizeMoney() {
        return NumberFormat.getInstance(Locale.KOREA).format(prizeMoney);
    }
}
