package lotto.constant;

import java.text.NumberFormat;
import java.util.Locale;

public enum WinningCondition {
    NO_MATCH(0, false, 0, ""),
    MATCH_3(3, false, 5_000, "3개 일치"),
    MATCH_4(4, false, 50_000, "4개 일치"),
    MATCH_5(5, false, 1_500_000, "5개 일치"),
    MATCH_5_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    MATCH_6(6, false, 2_000_000_000, "6개 일치");
    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeAmount;
    private final String message;

    WinningCondition(int matchCount, boolean bonusMatch, int prizeAmount, String message) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    @Override
    public String toString() {
        return message + " " + prizeAmountToString() + "-" + " ";
    }

    public String prizeAmountToString() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        String formattedAmount = formatter.format(prizeAmount);
        return "(" + formattedAmount + "원) ";
    }

}
