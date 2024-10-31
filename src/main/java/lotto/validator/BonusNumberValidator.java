package lotto.validator;

import lotto.exception.bonusNumber.BlankBonusNumberException;
import lotto.exception.bonusNumber.InvalidRangeBonusNumberException;
import lotto.exception.bonusNumber.NotNumberBonusNumberException;
import lotto.exception.bonusNumber.NotOneBonusNumberException;

public class BonusNumberValidator {

    private static final String REGEX_NUMBER = "^[0-9]+$";
    private static final int INPUT_SIZE = 1;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validate(final String input) {
        validateBlank(input);
        validateNumber(input);
        validateSize(input);
        int number = convert(input);
        validateRange(number);
    }

    private static void validateBlank(final String input) {
        if(input.isBlank()) {
            throw new BlankBonusNumberException();
        }
    }

    private static void validateNumber(final String input) {
        if(!input.matches(REGEX_NUMBER)) {
            throw new NotNumberBonusNumberException();
        }
    }

    private static void validateSize(final String input) {
        if(input.length() != INPUT_SIZE) {
            throw new NotOneBonusNumberException();
        }
    }

    private static void validateRange(final int number) {
        if(!(MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new InvalidRangeBonusNumberException();
        }
    }

    private static int convert(final String input) {
       return Integer.parseInt(input);
    }
}
