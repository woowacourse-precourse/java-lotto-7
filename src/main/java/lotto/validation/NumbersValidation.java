package lotto.validation;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.constant.LottoConstant.SIZE_NUMBERS;

import java.util.List;

public class NumbersValidation {

    private NumbersValidation() {
    }

    public static void validateAllRange(List<Integer> numbers, String errorMessage) {
        numbers.forEach(number -> validateRange(number, errorMessage));
    }

    public static void validateDuplicate(List<Integer> numbers, String errorMessage) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateSize(List<Integer> numbers, String errorMessage) {
        if (numbers.size() != SIZE_NUMBERS) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateRange(int number, String errorMessage) {
        if (MIN_NUMBER > number || MAX_NUMBER < number) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
