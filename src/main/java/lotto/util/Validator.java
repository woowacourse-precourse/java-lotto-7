package lotto.util;

import java.util.List;

public class Validator {
    public void validateEmptyInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public void validateNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }
    }

    public void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_NUMBER.getMessage());
        }
    }

    public void validateDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    public void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public void validateWinningNumbersContainBonus(String input, List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
