package lotto.validation;

import lotto.model.Lotto;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoNumbers.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoNumbers.MIN_LOTTO_NUMBER;

public class BonusNumberValidation {

    public static int parseBonusNumber(Lotto winningNumber, String inputBonusNumber) {
        int bonusNumber = parseNumber(inputBonusNumber);
        validateDuplication(winningNumber, bonusNumber);
        validateRange10To45(bonusNumber);
        return bonusNumber;
    }

    public static Integer parseNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_ONLY_CAN_NUMBER.getErrorMessage());
        }
    }

    public static void validateRange10To45(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_ONLY_CAN_RANGE_1_TO_45.getErrorMessage());
        }
    }

    public static void validateDuplication(Lotto winningNumber, int bonusNumber) {
        boolean isDuplicated = winningNumber.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber);
        if (isDuplicated) {
            throw new IllegalArgumentException(BONUS_NUMBER_CAN_NOT_BE_DUPLICATED_LOTTO_NUMBER.getErrorMessage());
        }
    }
}
