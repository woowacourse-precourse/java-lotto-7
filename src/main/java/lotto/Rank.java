package lotto;

import java.util.Arrays;

public enum Rank {
    THREE(3, false, 5_000, "3개 일치 (5,000원)"),
    FOUR(4, false, 50_000, "4개 일치 (50,000원)"),
    FIVE(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FIVE_AND_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    ETC(-1, false, 0, "당첨권 밖");
    ;

    private int matchingCount;
    private boolean isBonusMatched;
    private long prizeAmount;
    private String printMessage;

    Rank(int matchingCount, boolean isBonusMatched, long prizeAmount, String printMessage) {
        this.matchingCount = matchingCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeAmount = prizeAmount;
        this.printMessage = printMessage;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getPrintMessage() {
        return printMessage;
    }

    public static Rank getRank(int matchingCount, boolean isBonusMatched) {
        return Arrays.stream(Rank.values())
                .filter(type -> type.isMatched(matchingCount, isBonusMatched))
                .findFirst()
                .orElse(ETC);
    }

    private boolean isMatched(int matchingCount, boolean isBonusMatched) {
        return this.matchingCount == matchingCount &&
            this.isBonusMatched == isBonusMatched;
    }
}
