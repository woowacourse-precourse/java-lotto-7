package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.LottoConstants;
import lotto.view.ErrorMessage;

public class LottoValidator {

    public static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());
        }
    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < LottoConstants.MIN_NUMBER || num > LottoConstants.MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());
        }
    }

}
