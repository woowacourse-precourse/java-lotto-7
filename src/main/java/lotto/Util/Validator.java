package lotto.Util;

import static lotto.domain.Lotto.*;
import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.message.ExceptionMessage.*;
import static lotto.message.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.message.ExceptionMessage.DUPLICATED_WITH_WINNING_NUMBERS;
import static lotto.message.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.message.ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.ExceptionMessage;

public class Validator {
    public static void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public static void validateExactlySixNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateOutOfLottoNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateInputString(String input) {
        validateNullOrBlank(input);
    }

    public static void validateExistNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }
    public static void validateThousandUnitAmount(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NOT_IN_THOUSANDS.getMessage());
        }
    }

    private static void validateNullOrBlank(String input) {
        if (input.isBlank() || input == null) {
            throw new IllegalArgumentException(INPUT_NOTHING.getMessage());
        }
    }

    public static void validateDuplicatedBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
