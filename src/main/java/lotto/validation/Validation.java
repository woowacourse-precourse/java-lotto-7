package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionMessage;
import lotto.exception.InvalidLottoException;

public class Validation {
    public static void isUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        numbers.forEach(number -> {
            if (!uniqueNumbers.add(number)) {
                throw new InvalidLottoException(ExceptionMessage.ERROR_DUPLICATE_NUMBER);
            }
        });
    }

    public static void checkDivisibleBy1000(int number) {
        if (number % 1000 != 0) {
            throw new InvalidLottoException(ExceptionMessage.ERROR_NOT_DIVISIBLE_BY_1000);
        }
    }

    public static void checkPositive(int number) {
        if (number < 1) {
            throw new InvalidLottoException(ExceptionMessage.ERROR_NEGATIVE_NUMBER);
        }
    }

    public static void checkLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new InvalidLottoException(ExceptionMessage.ERROR_NOT_IN_LOTTO_NUMBER_RANGE);
        }
    }

    public static void checkLottoSize(List<Integer> number) {
        if (number.size() != 6) {
            throw new InvalidLottoException(ExceptionMessage.ERROR_LOTTO_SIZE_NOT_MATCHED);
        }
    }

    public static void checkBonusNumberUnique(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidLottoException(ExceptionMessage.ERROR_DUPLICATE_NUMBER);
        }
    }
}
