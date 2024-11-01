package lotto.model.lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto, final BonusNumber bonusNumber) {
        this.lotto = lotto;
        bonusNumber.validateDuplicated(lotto);
        this.bonusNumber = bonusNumber;
    }
}
