package lotto.domain;

import java.text.NumberFormat;
import java.util.Locale;

public enum WinningPrize {

    FAILURE("낙첨", 0),
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000);

    private final String matchCount;
    private final int prize;

    WinningPrize(String matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        return formatter.format(prize);
    }
}
