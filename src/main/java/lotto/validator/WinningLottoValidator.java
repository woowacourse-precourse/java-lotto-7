package lotto.validator;

import java.util.List;

public class WinningLottoValidator {

    private static final String ERROR_BONUS_NUMBER_DUPLICATE = "이미 당첨 번호에 포함되어 있는 번호 입니다.";

    public static void validateWinningLotto(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
