package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.util.RegexUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputValidator {
    private final int amount;
    private final int bonus;
    private List<Integer> winningNumbers;

    public InputValidator(AmountValidator amountValidator, WinningNumbersValidator winningNumbersValidator,
            BonusNumberValidator bonusValidator) {
        this.amount = amountValidator.processSetAmount();
        this.winningNumbers = winningNumbersValidator.convertTypeSetNumbers();
        this.bonus = bonusValidator.convertTypeSetBounus();

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

    public static Boolean isPositiveNumeric(String viewMessage, String input) {
        if (RegexUtils.isPositiveNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_POSITIVE_NUMERIC.getMessage());
    }

    public static Boolean hasNoDuplicates(String viewMessage, List<String> numbers) {
        Set<String> hashSet = new HashSet<>(numbers);

        if (hashSet.size() == numbers.size()) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.HAS_DUPLICATE_NUMBER.getMessage());
    }

    public int getAmount() {
        return amount;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

}
