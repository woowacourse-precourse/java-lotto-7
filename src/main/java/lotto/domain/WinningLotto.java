package lotto.domain;

import static lotto.validate.LottoNumberValidator.validateBonusNumberDuplicate;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) throws IllegalArgumentException {
        this.winningLotto = winningLotto;
        validateBonusNumberDuplicate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
