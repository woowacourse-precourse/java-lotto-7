package lotto.util.validator;

import static lotto.util.Constants.LOTTO_PRICE;

import java.util.regex.Pattern;
import lotto.util.ExceptionMessage;

public class BudgetValidator implements Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");
    private static final int MIN_BUDGET = 1_000;
    private static final int MAX_BUDGET = 100_000;


    @Override
    public void validate(String input) throws IllegalArgumentException {
        String budget = removeSpace(input);
        validateNumber(budget);       // 숫자 검증
        validateInputRange(budget);   // 범위 검증
        validateInputUnit(budget);    // 로또 가격 단위 검증

    }

    private static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    private void validateNumber(String budget) {
        if (NUMBER_REGEX.matcher(budget).matches()) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
    }

    private void validateInputRange(String budget) {
        int budgetValue = Integer.parseInt(budget);
        if (budgetValue < MIN_BUDGET || budgetValue > MAX_BUDGET) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_BUDGET_RANGE.getMessage());
        }
    }
    private void validateInputUnit(String budget) {
        int remainder = Integer.parseInt(budget) % LOTTO_PRICE;
        if (remainder == 0) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT_OF_BUDGET.getMessage());
    }


}
