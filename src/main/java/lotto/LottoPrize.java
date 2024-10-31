package lotto;

public enum LottoPrize {
    FIRST_PRIZE("2,000,000,000"),
    SECOND_PRIZE("30,000,000"),
    THIRD_PRIZE("1,500,000"),
    FOURTH_PRIZE("50,000"),
    FIFTH_PRIZE("5,000");


    private final String prizeAmount;

    LottoPrize(String prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public int getPrizeAmountAsInteger() {
        return Integer.parseInt(prizeAmount.replace(",", ""));
    }
}
