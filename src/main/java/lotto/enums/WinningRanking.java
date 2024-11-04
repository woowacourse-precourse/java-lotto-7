package lotto.enums;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum WinningRanking {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000, true),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;
    private final boolean needBonusNumber;

    WinningRanking(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    WinningRanking(int matchCount, int prize, boolean needBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.needBonusNumber = needBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean needBonusNumber() {
        return needBonusNumber;
    }

    public static WinningRanking getWinningRanking(int matchCount, boolean needBonusNumber) {
        return Arrays.stream(WinningRanking.values())
                .filter(grade -> grade.getMatchCount() == matchCount)
                .filter(grade -> grade.needBonusNumber() == needBonusNumber || !grade.needBonusNumber)
                .findFirst().orElse(null);
    }

    public String getKoreaFormatPrize() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(prize);
    }


}
