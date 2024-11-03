package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonus;

    public WinningLotto(Lotto winningLotto, BonusNumber bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }
}
