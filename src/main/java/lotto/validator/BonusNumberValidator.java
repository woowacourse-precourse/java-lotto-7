package lotto.validator;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;

import java.util.List;

public class BonusNumberValidator {
    private static final Integer MININUM_NUMBER = 1;
    private static final Integer MAXIM1UM_NUMBER = 45;

    public static int validateBonusNumber(String input){
        CommonValidator.validateNullAndBlank(input);
        int bonusNumber=validatePositiveNumber(input);
        validateBonusNumberInRange(bonusNumber);

        return bonusNumber;
    }

    private static int validatePositiveNumber(String input){
        if (!RegexPattern.INTEGER_INPUT.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT);
        }
        return Integer.parseInt(input);

    }

    private static void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber<MININUM_NUMBER || bonusNumber>MAXIM1UM_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
