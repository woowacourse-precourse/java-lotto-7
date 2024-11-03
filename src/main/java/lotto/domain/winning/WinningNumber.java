package lotto.domain.winning;

import static lotto.exception.message.WinningNumberExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.message.WinningNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.exception.WinningNumberException;

public class WinningNumber {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumberDuplication(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberDuplication(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new WinningNumberException(DUPLICATE_BONUS_NUMBER);
        }
    }

    public LottoRank match(Lotto lotto) {
        return LottoRank.of(
                winningLotto.match(lotto),
                lotto.contains(bonusNumber)
        );
    }

}
