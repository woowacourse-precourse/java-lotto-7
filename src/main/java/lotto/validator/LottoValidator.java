package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.ExceptionMessage;
import lotto.model.LottoType;

public class LottoValidator {

    public static void validateLotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersRange(numbers);
        validateNumberDuplicate(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COUNT.getMessage());
        }
    }

    private static void validateNumberDuplicate(List<Integer> numbers) {
        HashSet<Integer> lottoNumberSet = new HashSet<>(numbers);
        if (lottoNumberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(int number) {
        if (LottoType.MIN_NUMBER.getNumber() > number || LottoType.MAX_NUMBER.getNumber() < number) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_NUMBER.getMessage());
        }
    }

    public static void validateNotContainBonusNumber(Set<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_CONTAINED.getMessage());
        }
    }
}
