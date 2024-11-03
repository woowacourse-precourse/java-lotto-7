package lotto.Model;

public enum Rank {
    THREE(5000, "3개 일치"),
    FOUR(50000, "4개 일치"),
    FIVE(1500000, "5개 일치"),
    BONUS(30000000, "5개 일치, 보너스 볼 일치"),
    SIX(2000000000, "6개 일치");

    private final int WinningMoney;
    private final String Agreement;

    Rank(int PlayCount, String Agreement) {
        this.WinningMoney = PlayCount;
        this.Agreement = Agreement;
    }

    public int GetWinningMoney() {
        return WinningMoney;
    }

    public String GetAgreement() {
        return Agreement;
    }
}