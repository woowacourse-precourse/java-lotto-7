package lotto;

import java.util.Arrays;

public enum Ranking {

    NONE(0, false, 0, "당첨 없음"),
    PICK3(3, false, 5_000, "3개 일치 (5,000원)"),
    PICK4(4, false, 50_000, "4개 일치 (50,000원)"),
    PICK5(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    PICK5_WITH_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    PICK6(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int correctNumbers;
    private final int prizeAmount;
    private final boolean isBonus;
    private final String printMessage;

    Ranking(int correctNumbers, boolean isBonus, int prizeAmount, String printMessage) {
        this.correctNumbers = correctNumbers;
        this.prizeAmount = prizeAmount;
        this.isBonus = isBonus;
        this.printMessage = printMessage;
    }

    public static Ranking getRank(int matchedCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.correctNumbers == matchedCount && ranking.isBonus == bonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    public String getPrintMessage() {
        return this.printMessage;
    }

    public long getPrizeAmount() {
        return this.prizeAmount;
    }

}
