package lotto.domain;

public enum Winners {
    THREE_MATCHED(3, "5,000"),
    FOUR_MATCHED(4, "50,000"),
    FIVE_MATCHED(5, "1,500,000"),
    FIVE_BONUS_MATCHED(5, "30,000,000"),
    SIX_MATCHED(6, "2,000,000,000");

    private final int matchedNumber;
    private final String prizeMoney;

    Winners(int matchedNumber, String prizeMoney) {
        this.matchedNumber = matchedNumber;
        this.prizeMoney = prizeMoney;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int convertPrizeMoneyToInt() {
        return Integer.parseInt(prizeMoney.replace(",", ""));
    }
}
