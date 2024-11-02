package lotto.util.validator;

import static lotto.message.ErrorMessage.DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_RANGE_BONUS_NUMBER_ERROR_MESSAGE;

import java.util.List;
import lotto.dto.LottoStatus;
import lotto.model.Lotto;

public class BonusNumberValidator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validate(Lotto winningLotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplication(winningLotto, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (!isValidRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_RANGE_BONUS_NUMBER_ERROR_MESSAGE.getContent());
        }
    }

    private static boolean isValidRange(int bonusNumber) {
        return LOTTO_MIN_NUMBER <= bonusNumber && bonusNumber <= LOTTO_MAX_NUMBER;
    }

    private static void validateDuplication(Lotto winningLotto, int bonusNumber) {
        LottoStatus status = winningLotto.getStatus();
        List<Integer> winningNumbers = status.getNumbers();

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE.getContent());
        }
    }
}
