package lotto.common;

public enum WinMoney {
    THREERIGHT("5,000원"),
    FOURGRIGHT("50,000원"),
    FIVERIGHT("1,500,000원"),
    FIVEWRIGHTANDBONUS("30,000,000원"),
    SIXRIGHT("2,000,000,000원"),
    THREECOUNTKEY("3개"),
    FOURCOUNTKEY("4개"),
    FIVECOUNTKEY("5개"),
    FIVEANDBONUSKEY("5개, 보너스 볼"),
    SIXCOUNTKEY("6개");

    private final String winMoneyStr;

    WinMoney(String winMoneyStr) {
        this.winMoneyStr = winMoneyStr;
    }

    public String getWinMoneyStr() {
        return winMoneyStr;
    }

}
