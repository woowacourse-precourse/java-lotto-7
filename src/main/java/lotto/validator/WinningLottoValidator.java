package lotto.validator;

import lotto.utils.LottoException;

import java.util.List;

import static lotto.constants.ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE;

public class WinningLottoValidator {

    private WinningLottoValidator() {
    }

    public static void validateWinningLotto(final List<Integer> winNumbers, final int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new LottoException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
