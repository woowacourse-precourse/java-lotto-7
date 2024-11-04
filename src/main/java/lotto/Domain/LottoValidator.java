package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import lotto.Enum.LottoRange;
import lotto.Messages.ErrorMessages;

public class LottoValidator {

    public static void validateLottoNumber(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(bonusNumber, numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_SIZE.message);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LottoRange.LOTTO_LOWEST_NUMBER.getValue()
                        || number >= LottoRange.LOTTO_HIGHEST_NUMBER.getValue());

        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_RANGE.message);
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_DUPLICATE.message);
        }
    }

    private static void validateBonusRange(int bonusNumber) {
        if (bonusNumber < LottoRange.LOTTO_LOWEST_NUMBER.getValue()
                || bonusNumber >= LottoRange.LOTTO_HIGHEST_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_RANGE.message);
        }
    }

    private static void validateBonusDuplicate(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_DUPLICATE.message);
        }
    }
}
}
