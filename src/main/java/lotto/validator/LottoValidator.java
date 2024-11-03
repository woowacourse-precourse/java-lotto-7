package lotto.validator;

import static lotto.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class LottoValidator {

    // 모든 검증을 수행하는 validate 메서드
    public static void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    private static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_INVALID.getMessage());
        }
    }

}
