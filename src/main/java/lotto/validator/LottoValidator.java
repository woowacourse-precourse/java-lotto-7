package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class LottoValidator {

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoConstants.MIN_NUMBER || bonusNumber > LottoConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER));
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NUMBER_COUNT.getMessage(LottoConstants.NUMBER_COUNT));
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream()
                .allMatch(number -> number >= LottoConstants.MIN_NUMBER && number <= LottoConstants.MAX_NUMBER)) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER));
        }
    }
}
