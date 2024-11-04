package lotto;


public class WinningNumber {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        LottoNumberValidator.validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int findMatchCount(Lotto userLotto) {
        return this.lotto.findMatchCount(userLotto);
    }
}
