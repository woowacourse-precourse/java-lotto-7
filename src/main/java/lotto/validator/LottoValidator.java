package lotto.validator;

import lotto.model.Lotto;

import java.util.List;

import static lotto.model.enums.ErrorMessage.*;

public class LottoValidator {

    static final int START_LOTTO_VALUE = 1;
    static final int END_LOTTO_VALUE = 45;


    public static void validateLottoNumbers(List<Integer> numbers) {
        if (!areInRange(numbers)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBERS_RANGE.getMessage());
        }
        if (!areUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
        }
        if (!isInRange(bonusNumber) ) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean areUniqueNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    private static boolean areInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(LottoValidator::isInRange);
    }

    private static boolean isInRange(int number) {
        return number >= START_LOTTO_VALUE && number <= END_LOTTO_VALUE;
    }
}
