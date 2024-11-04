public enum LottoPlace {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);

    private int winningMoney;

    LottoPlace(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
