package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonus;

    public WinningLotto(Lotto winningLotto, BonusNumber bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Rank findRank(Lotto lotto) {
        return Rank.of(winningLotto.countMatching(lotto), hasBonus(lotto));
    }

    private boolean hasBonus(Lotto lotto) {
        return lotto.contains(bonus.getNumber());
    }
}
