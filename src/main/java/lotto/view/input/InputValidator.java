package lotto.view.input;

import static lotto.view.input.InputError.*;

import java.util.List;

public class InputValidator {
    private final int AMOUNT_UNIT = 1000;
    private final int MAX_AMOUNT = 100000;
    private final int WINNING_NUMBER_SIZE = 6;
    private final int MIN_LOTTO_NUM = 1;
    private final int MAX_LOTTO_NUM = 45;

    public void validateAmount(Integer amount) {
        validateAmountUnit(amount);
        validateMaxAmount(amount);
        validateMinAmount(amount);
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        validateCountOfNumbers(numbers);
        validateNumberRange(numbers);
    }

    public void validateBonusNumber(Integer number) {
        validateNumberRange(number);
    }

    private void validateAmountUnit(Integer amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERR.getMessage());
        }
    }

    private void validateMaxAmount(Integer amount) {
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_ERR.getMessage());
        }
    }

    private void validateMinAmount(Integer amount) {
        if (amount < AMOUNT_UNIT) {
            throw new IllegalArgumentException(MIN_AMOUNT_ERR.getMessage());
        }
    }

    private void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_ERR.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isInRange = numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUM && num <= MAX_LOTTO_NUM);

        if (!isInRange) {
            throw new IllegalArgumentException(LOTTO_NUM_OUT_OF_RANGE_ERR.getMessage());
        }
    }

    private void validateNumberRange(Integer number) {
        boolean isInRange = number >= MIN_LOTTO_NUM && number <= MAX_LOTTO_NUM;

        if (!isInRange) {
            throw new IllegalArgumentException(LOTTO_NUM_OUT_OF_RANGE_ERR.getMessage());
        }
    }


}
