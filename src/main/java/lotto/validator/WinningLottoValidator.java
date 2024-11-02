package lotto.validator;

import lotto.utils.ExceptionUtils;

import java.util.List;

public class WinningLottoValidator {

    private static final String ERROR_BONUS_NUMBER_DUPLICATE = "이미 당첨 번호에 포함되어 있는 번호 입니다.";

    public static void validateWinningLotto(final List<Integer> winNumbers, final int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            ExceptionUtils.throwIllegalArgument(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
