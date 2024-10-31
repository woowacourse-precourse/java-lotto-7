package lotto;

public class WinningNumbers {

    private final Lotto lotto;
    private final int bonusBall;

    public WinningNumbers(Lotto lotto, int bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
