package lotto.validator;

import lotto.enums.ExceptionMessage;

import java.util.List;

public class BonusValidator implements Validator {
    private final List<Integer> winningNumbers;

    public BonusValidator(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate(String input){
        validateNull(input);
        validateNumeric(input);
        validateNonZeroStart(input);
        int number = Integer.parseInt(input);
        validateRange(number);
        validateDuplicate(winningNumbers,number);
    }

    private void validateRange(int number){

        if(number < 1 || number > 45){
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers, int number){
        if(winningNumbers.contains(number)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }
}
