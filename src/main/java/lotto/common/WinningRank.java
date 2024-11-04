package lotto.common;

import java.util.Arrays;

public enum WinningRank {
    FIRST_PLACE(6, false, false, "2,000,000,000"),
    SECOND_PLACE(5, true, true, "30,000,000"),
    THIRD_PLACE(5, false, false, "1,500,000"),
    FOURTH_PLACE(4, false, false, "50,000"),
    FIFTH_PLACE(3, false, false, "5,000"),
    NOT_IN_PLACE(0, false, false, "0");

    private final int matchedCount;
    private final boolean isMatchedBonusNumber;
    private final boolean isRequiredBonusNumber;
    private final String winningAmount;

    WinningRank(int matchedCount, boolean isMatchedBonusNumber
            , boolean isRequiredBonusNumber, String winningAmount) {
        this.matchedCount = matchedCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.isRequiredBonusNumber = isRequiredBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static WinningRank determine(int matchedCount, boolean isMatchedBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedCount == matchedCount &&
                        (rank.isMatchedBonusNumber == isMatchedBonusNumber || !rank.isRequiredBonusNumber))
                .findFirst()
                .orElse(NOT_IN_PLACE);
    }

    public int getWinningAmount() {
        String numberPart = winningAmount.replace(",", "");
        int amount = Integer.parseInt(numberPart);
        return amount;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public String getWinningAmountInfo() {
        String winningAmountInfo = winningAmount + "원";
        return winningAmountInfo;
    }

    public String getPhraseIfMatchedBonusNumber() {
        if(isMatchedBonusNumber) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}