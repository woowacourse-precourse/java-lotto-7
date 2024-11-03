package lotto.validator;

import lotto.LottoConstants;
import lotto.model.Lotto;

public class BonusNumberValidator {

    public static final String ERROR_MESSAGE_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_BONUS_NUMBER_SAME_AS_WINNING_NUMBER = "[ERROR] 보너스 번호는 로또 당첨 번호와 중복되지 않는 번호를 입력해야 합니다.";

    public static void validateBonusNumber(Lotto lotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotInLotto(lotto, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_RANGE);
        }
    }

    private static boolean isOutOfRange(int bonusNumber) {
        return bonusNumber > LottoConstants.MAX_LOTTO_NUMBER.getValue()
                || bonusNumber < LottoConstants.MIN_LOTTO_NUMBER.getValue();
    }

    private static void validateBonusNumberNotInLotto(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_SAME_AS_WINNING_NUMBER);
        }
    }
}
