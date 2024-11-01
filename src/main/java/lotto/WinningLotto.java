package lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonus = new LottoNumber(bonusNumber);
    }

    public Rank match(Lotto lotto) {
        return Rank.match(matchCount(lotto), hasBonus(lotto));
    }

    private int matchCount(Lotto lotto) {
        return this.lotto.matchCount(lotto);
    }

    private boolean hasBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
