package lotto.domain.winning;

import static lotto.exception.message.WinningNumberExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.message.WinningNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;

import lotto.domain.lotto.Lotto;
import lotto.exception.WinningNumberException;

public class WinningNumber {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumber(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumberDuplication(winningNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new WinningNumberException(DUPLICATE_BONUS_NUMBER);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new WinningNumberException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    public LottoRank match(Lotto lotto) {
        return LottoRank.of(
                winningLotto.match(lotto),
                lotto.contains(bonusNumber)
        );
    }

}
