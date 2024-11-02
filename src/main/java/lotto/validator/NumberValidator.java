package lotto.validator;

import static lotto.constant.PriceRule.MATCH_NUMBER;

public class NumberValidator {

    public static void validateOnlyInteger(String input, String ErrorMessage) throws IllegalArgumentException {
        if (!input.matches(MATCH_NUMBER.getMessage())) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }

    public static void validateScope(int minimum, int maximum, int target, String ErrorMessage) throws IllegalArgumentException {
        if (target < minimum || maximum < target) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }
}