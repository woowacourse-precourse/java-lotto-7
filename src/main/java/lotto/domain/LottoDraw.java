package lotto.domain;

import static lotto.constant.LottoConstant.*;

import lotto.exception.LottoException;
import lotto.exception.message.LottoExceptionMessage;

public class LottoDraw {

    private final Lotto winningLotto;
    private final int bonusNumber;

    private LottoDraw(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoDraw of(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        return new LottoDraw(winningLotto, bonusNumber);
    }

    private static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        validateLottoContainBonusNumber(winningLotto,bonusNumber);
    }

    private static void validateBonusNumberInRange(int bonusNumber){
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new LottoException(LottoExceptionMessage.INVALID_LOTTO_NUMBER);
        }
    }

    private static void validateLottoContainBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new LottoException(LottoExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
