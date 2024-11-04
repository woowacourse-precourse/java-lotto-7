package lotto.constant;

public enum Rank {
    FIRST(6,2_000_000_000,false),
    SECOND(5,30_000_000,true),
    Third(5,1_500_000,false),
    FIRTH(4,50_000,false),
    FIFTH(3,5_000,false);


    private final int correctNumber;
    private final int winningPrize;
    private final boolean bonusNumberCheck;

    Rank(int correctNumber, int winningPrize, boolean bonusNumberCheck) {
        this.correctNumber = correctNumber;
        this.winningPrize = winningPrize;
        this.bonusNumberCheck = bonusNumberCheck;
    }

    public int correctNumber() {
        return correctNumber;
    }

    public int winningPrize() {
        return winningPrize;
    }

    public boolean bonusNumberCheck() {
        return bonusNumberCheck;
    }
}
