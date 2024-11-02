package lotto.common;

public enum WinMoney {
    THREEMONEY(5000),
    FOURMONEY(50000),
    FIVEMONEY(1500000),
    FIVEANDBONUSMONEY(30000000),
    SIXMONEY(2000000000);

    private final Integer winMoney;

    private WinMoney(Integer winMoney) {
        this.winMoney = winMoney;
    }

    public Integer getWinMoney() {
        return winMoney;
    }
}
