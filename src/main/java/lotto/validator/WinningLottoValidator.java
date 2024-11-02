package lotto.validator;

import lotto.utils.ExceptionUtils;

import java.util.List;

import static lotto.constants.ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE;

public class WinningLottoValidator {

    public static void validateWinningLotto(final List<Integer> winNumbers, final int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            ExceptionUtils.throwIllegalArgument(ERROR_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
