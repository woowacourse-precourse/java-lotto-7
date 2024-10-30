package lotto.validator;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;
import lotto.domain.WinningNumbers;

import java.util.List;

public class BonusNumberValidator {
    private static final Integer MININUM_NUMBER = 1;
    private static final Integer MAXIM1UM_NUMBER = 45;

    public static void validateBonusNumber(String input,List<Integer> winningNumbers){
        CommonValidator.validateNullAndBlank(input);
        CommonValidator.validateInteger(input);

        int bonusNumber=Integer.parseInt(input);

        validateBonusNumberInRange(bonusNumber);
        validateDistinctToWinnerNumbers(bonusNumber,winningNumbers);
    }

    private static void validateDistinctToWinnerNumbers(int bonusNumber,List<Integer> winningNumbers) {
       boolean haveDuplicatedNumber=winningNumbers.stream().anyMatch(winningNumber->winningNumber==bonusNumber);

       if (haveDuplicatedNumber){
           throw new IllegalArgumentException(ErrorMessage.DUPLICATED_TO_WINNING_NUMBERS);
       }
    }

    private static void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber<MININUM_NUMBER || bonusNumber>MAXIM1UM_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
