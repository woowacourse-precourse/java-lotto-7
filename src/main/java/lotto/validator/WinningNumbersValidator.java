package lotto.validator;

import static lotto.message.ErrorMessage.INVALID_NUMBER_ERROR;
import static lotto.message.ErrorMessage.INVALID_NUMBER_SIZE_ERROR;
import static lotto.message.ErrorMessage.PARSE_INT_NUMBERS_ERROR;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbersValidator {
    private List<Integer> numbers;

    public boolean isNotValidWinningNumbers(String userInput) {
        if (isNotParsableToNumbers(userInput)) {
            return true;
        }
        if (hasInvalidNumber(numbers)) {
            return true;
        }
        return isInValidNumberSize(numbers);
    }

    private boolean isNotParsableToNumbers(String userInput) {
        try {
            numbers = Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println(PARSE_INT_NUMBERS_ERROR.getMessage());
            return true;
        }
        return false;
    }

    private boolean hasInvalidNumber(List<Integer> numbers) {
        try {
            numbers.forEach(number -> {
                if (number < Lotto.LOTTO_NUMBER_MIN || Lotto.LOTTO_NUMBER_MAX < number) {
                    throw new IllegalArgumentException();
                }
            });
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER_ERROR.getMessage());
            return true;
        }
        return false;
    }

    private boolean isInValidNumberSize(List<Integer> numbers) {
        try {
            if (numbers.size() != Lotto.LOTTO_SIZE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER_SIZE_ERROR.getMessage());
            return true;
        }
        return false;
    }
}
