package lotto.validation;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_ONLY_CAN_NUMBER;

public class BonusNumberValidation {
    public static void validate(String inputBonusNumber){
        Integer bonusNumber = parseNumber(inputBonusNumber);
    }

    public static Integer parseNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_ONLY_CAN_NUMBER.getErrorMessage());
        }
    }
}
