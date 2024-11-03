package lotto;

public enum LottoResult {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private int match;
    private boolean bonusMatch;
    private int winningMoney;

    LottoResult(int match, boolean bonusMatch, int winningMoney) {
        this.match = match;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }
};
