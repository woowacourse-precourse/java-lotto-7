package lotto;

import java.text.NumberFormat;

public enum Prize {

    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NONE(0, 0, false);

    private final int prizeMoney;
    private final int matchCount;
    private final boolean bonusRequired;

    Prize(int money, int match, boolean bonusMatched) {
        this.prizeMoney = money;
        this.matchCount = match;
        this.bonusRequired = bonusMatched;
    }

    public static Prize getPrizeByMatch(int winCount, boolean bonusMatched) {
        for (Prize prize: Prize.values()) {
            if (winCount == prize.matchCount && bonusMatched == prize.bonusRequired) {
                return prize;
            }
        }
        return NONE;
    }

    public int calculateTotalPrize(int numberOfWinners) {
        return numberOfWinners * prizeMoney;
    }

    public String toString(int count) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedPrizeMoney = numberFormat.format(prizeMoney);

        if (bonusRequired) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", matchCount, formattedPrizeMoney, count);
        }
        return String.format("%d개 일치 (%s원) - %d개", matchCount, formattedPrizeMoney, count);
    }
}
