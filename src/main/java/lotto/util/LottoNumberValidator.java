package lotto.util;

import static lotto.constant.ErrorMessage.DUPLICATION_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_RANGE;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_SIZE;

import java.util.List;

public class LottoNumberValidator {
    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private static void validateDuplication(List<Integer> numbers) {
        boolean hasDuplication = numbers.size() != numbers.stream()
                .distinct()
                .count();
        if (hasDuplication) {
            throw new IllegalArgumentException(DUPLICATION_LOTTO_NUMBER.getMessage());
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
            }
        }
    }

    public static void validateRange(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
        }
    }
}
