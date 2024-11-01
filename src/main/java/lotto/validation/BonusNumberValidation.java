package lotto.validation;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoNumbers.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoNumbers.MIN_LOTTO_NUMBER;
import static lotto.validation.WinningNumberValidation.parsedWinningNumbers;

public class BonusNumberValidation {
    public static int bonusNumber;

    public static void validate(String inputBonusNumber) {
        bonusNumber = parseNumber(inputBonusNumber);
        validateRange10To45(bonusNumber);
        validateDuplication(bonusNumber);
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

    public static void validateDuplication(int bonusNumber) {
        boolean isDuplicated = parsedWinningNumbers.stream().anyMatch(number -> number == bonusNumber);
        if (isDuplicated) {
            throw new IllegalArgumentException(BONUS_NUMBER_CAN_NOT_BE_DUPLICATED_LOTTO_NUMBER.getErrorMessage());
        }
    }
}
