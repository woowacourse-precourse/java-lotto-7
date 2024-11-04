package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 %d개여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private static final String WINNING_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 %d부터 %d 사이의 값이여야 합니다.";
    private static final String WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String WINNING_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 %d개여야 합니다.";

    public static void validateWinningNumbersDuplicate(final List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<>();
        for (Integer winningNumber : winningNumbers) {
            checkDuplicateNumber(winningNumber, winningNumberSet);
        }
    }

    public static void checkDuplicateNumber(final Integer number, final Set<Integer> numberSet) {
        if (!numberSet.contains(number)) {
            numberSet.add(number);
            return;
        }
        throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE);
    }

    public static void validateWinningCount(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(WINNING_NUMBER_COUNT_ERROR_MESSAGE, LOTTO_NUMBER_COUNT));
        }
    }

    public static void validateWinningNumbersRange(final List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            validateRange(winningNumber);
        }
    }

    public static void validateRange(Integer number) {
        if ((number > LOTTO_MAX_NUMBER) || (number < LOTTO_MIN_NUMBER)) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBER_RANGE_ERROR_MESSAGE, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }


    public static void validateBonusNumber(final List<Integer> winningNumbers, final Integer bonusNumber) {
        validateRange(bonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBER_COUNT_ERROR, LOTTO_NUMBER_COUNT));
        }
    }

    public static void validateNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateDuplicate(number, numberSet);
        }
    }

    public static void validateDuplicate(final Integer number, final Set<Integer> numberSet) {
        if (!numberSet.contains(number)) {
            numberSet.add(number);
            return;
        }
        throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
    }

    public static void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(Validator::validateRange);
    }


}
