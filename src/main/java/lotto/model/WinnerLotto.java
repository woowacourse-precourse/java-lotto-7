package lotto.model;

public class WinnerLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinnerLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
