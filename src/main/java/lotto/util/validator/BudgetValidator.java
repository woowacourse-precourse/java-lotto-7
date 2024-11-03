package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.util.ExceptionMessage;

public class BudgetValidator implements Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private static final int MIN_BUDGET = 1_000;
    private static final int MAX_BUDGET = 100_000;


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

    private void validateRange(String budget) {
        int budgetValue = Integer.parseInt(budget);
        if (budgetValue < MIN_BUDGET || budgetValue > MAX_BUDGET) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANNGE_OF_BUDGET.getMessage());
        }
    }


}
