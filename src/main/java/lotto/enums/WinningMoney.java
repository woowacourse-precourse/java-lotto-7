package lotto.enums;

public enum WinningMoney {
    FIRST_PRIZE_MONEY("2,000,000,000원"),
    SECOND_PRIZE_MONEY("30,000,000원"),
    THIRD_PRIZE_MONEY("1,500,000원"),
    FOURTH_PRIZE_MONEY("50,000원"),
    FIFTH_PRIZE_MONEY("5,000원");

    private final String prizeMoney;

    WinningMoney(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
