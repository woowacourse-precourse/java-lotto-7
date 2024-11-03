package lotto.util;

import static lotto.exception.LottoErrorStatus.EMPTY_USER_INPUT;
import static lotto.exception.LottoErrorStatus.INVALID_BUDGET_AMOUNT;
import static lotto.exception.LottoErrorStatus.INVALID_BUDGET_FORMAT;

import lotto.exception.LottoException;

public class BudgetValidator {
    private BudgetValidator() {
    }


    public static void validateInputBudget(String inputBudget) {
        validateNotEmpty(inputBudget);
        validateNumberFormat(inputBudget);
        validateIntegerFormat(inputBudget);
    }

    private static void validateNotEmpty(String inputBudget) {
        if (inputBudget == null || inputBudget.isEmpty()) {
            throw new LottoException(EMPTY_USER_INPUT);
        }
    }

    private static void validateNumberFormat(String inputBudget) {
        if (!inputBudget.matches("\\d+")) {
            throw new LottoException(INVALID_BUDGET_FORMAT);
        }
    }

    private static void validateIntegerFormat(String inputBudget) {
        try {
            Integer.parseInt(inputBudget);
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_BUDGET_AMOUNT);
        }
    }
}
