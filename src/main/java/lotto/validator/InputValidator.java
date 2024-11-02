package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.util.RegexUtils;

import java.util.Set;


public class InputValidator {
    private final int amount;
    private int bonus;
    private Set<Integer> winningNumbers;
    private Set<String> duplicateCheck;

    public InputValidator(AmountValidator amountValidator) {
        this.amount = amountValidator.processSetAmount();

    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public static Boolean nonEmpty(String viewMessage, String input) {
        if (!input.isEmpty()) {
            return true;
        }

        throw new RetryInputException(viewMessage, input);
    }

    public static Boolean isNumeric(String viewMessage, String input) {
        if (RegexUtils.isNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_NUMERIC.getMessage());
    }

    public static Boolean isPositiveNumber(String viewMessage, String input) {
        if (RegexUtils.isPositiveNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_POSITIVE_NUMERIC.getMessage());
    }




}
