package lotto.validation;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_ONLY_CAN_NUMBER;
import static lotto.constants.ErrorMessage.BONUS_NUMBER_ONLY_CAN_RANGE_1_TO_45;
import static lotto.constants.LottoNumbers.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoNumbers.MIN_LOTTO_NUMBER;

public class BonusNumberValidation {
    public static void validate(String inputBonusNumber) {
        Integer bonusNumber = parseNumber(inputBonusNumber);
        validateRange10To45(bonusNumber);
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
}
