package lotto.domain;

import java.util.List;
import lotto.constant.Constant;
import lotto.exception.ErrorMessage;

public class Bonus {
    private final int number;

    private Bonus(int number) {
        this.number = number;
    }

    public static Bonus of(String input, Lotto winningLotto) {
        input = input.trim();
        validate(input, winningLotto);
        return new Bonus(Integer.parseInt(input));
    }

    private static void validate(String input, Lotto winningLotto) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input, winningLotto);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches(Constant.NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateRange(String input, Lotto winningLotto) {
        int number = parseInt(input);
        validateNumberRange(number);
        validateDuplicate(number, winningLotto.getNumbers());
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TOO_BIG_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateDuplicate(int bonus, List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
