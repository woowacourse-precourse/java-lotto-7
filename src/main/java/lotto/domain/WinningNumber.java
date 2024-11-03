package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class WinningNumber {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicate(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw LottoException.from(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_LOTTO);
        }
    }
}
