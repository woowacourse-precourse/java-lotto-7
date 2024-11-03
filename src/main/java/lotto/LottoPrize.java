package lotto;

import java.text.DecimalFormat;

public enum LottoPrize {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoPrize(int matchingCount, boolean bonusMatch, int prize) {
        this.matchingCount = matchingCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public void printPrizeResult(int count) {
        DecimalFormat formatter = new DecimalFormat("#,###"); // 천 단위 구분 쉼표 형식
        String formattedPrize = formatter.format(prize);

        if (this == SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", matchingCount, formattedPrize, count);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", matchingCount, formattedPrize, count);
    }
}
