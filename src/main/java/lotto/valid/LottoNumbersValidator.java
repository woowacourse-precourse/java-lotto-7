package lotto.valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constant.*;

public class LottoNumbersValidator {

    // 로또 번호 리스트에 대한 전체 검증
    public static void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_COUNT);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_LOTTO_RANGE);
            }
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }
}
