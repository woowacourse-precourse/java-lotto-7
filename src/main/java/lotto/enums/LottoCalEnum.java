package lotto.enums;

public enum LottoCalEnum {
    WIN_THREE(3,5000),
    WIN_FOUR(4,50000),
    WIN_FIVE(5,1500000),
    WIN_FIVE_WITH_BONUS(7,30000000),
    WIN_SIX(6,2000000000),
    ;

    public int getWinCount() {
        return winCount;
    }

    public int getWinMoney() {
        return winMoney;
    }

    private final int winCount;
    private final int winMoney;

    LottoCalEnum(int winCount,int winMoney) {
        this.winCount = winCount;
        this.winMoney = winMoney;
    }
}
