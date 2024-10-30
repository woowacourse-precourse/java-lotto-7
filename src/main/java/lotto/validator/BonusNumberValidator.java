package lotto.validator;

import lotto.common.CommonValidator;

public class BonusNumberValidator {

    public static void validateBonusNumber(String input){
        CommonValidator.validateNullAndBlank(input);
        CommonValidator.validateInteger(input);

        int bonusNumber=Integer.parseInt(input);

        //validateNumberInRange(bonusNumber);
        //validateDistinctToWinnerNumbers(bonusNumber);
    }
}
