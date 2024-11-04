package lotto.validation;

import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class ValidatorImpl implements Validator {
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int ZERO = 0;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    @Override
    public int validate(String input) {
        int amount = parseInput(input);
        validateAmount(amount);
        return amount;
    }

    @Override
    public int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMERIC);
        }
    }

    @Override
    public void winningNumbers(List<Integer> winningNumbers) {
        validateNumbers(winningNumbers);
        checkForDuplicates(winningNumbers);
    }

    @Override
    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberInRange(bonusNumber, ERROR_INVALID_NUMBER);
        checkBonusNumberDuplication(bonusNumber, winningNumbers);
    }

    private void validateAmount(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_AMOUNT);
        }
        if (amount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        numbers.forEach(number -> validateNumberInRange(number, ERROR_INVALID_NUMBER));
    }

    private void validateNumberInRange(int number, String errorMessage) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void checkForDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    private void checkBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }
}
