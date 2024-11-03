package lotto.domain.enums;

import java.text.DecimalFormat;

public enum WinningStatistics {

    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_MATCHES_WITH_BONUS(5, 30000000),
    SIX_MATCHES(6, 2000000000);

    private final DecimalFormat formatter = new DecimalFormat("#,###");

    private final int cnt;
    private final int prizeMoney;

    WinningStatistics(int cnt, int prizeMoney) {
        this.cnt = cnt;
        this.prizeMoney = prizeMoney;
    }

    public int getCnt() {
        return cnt;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getFormatPrizeMoney() {
        return formatter.format(prizeMoney);
    }
}
