package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(final Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean matchBonus(final Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
