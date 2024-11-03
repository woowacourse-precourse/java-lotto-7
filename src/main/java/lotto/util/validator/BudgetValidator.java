package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.util.ExceptionMessage;

public class BudgetValidator implements Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");


    @Override
    public void validate(String input) throws IllegalArgumentException {
        String budget = removeSpace(input);
        validate(budget);

    }
    private static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
    private void validateNumber(String budget) {
        if (NUMBER_REGEX.matcher(budget).matches()) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
    }

}
