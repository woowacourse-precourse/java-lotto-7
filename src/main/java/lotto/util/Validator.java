package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.common.ErrorMessage.*;

public class Validator { // TODO: 확장 시 인터페이스 구현체로 구현
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    public static void checkEmpty(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    public static void checkIntegerRange(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            // TODO: 알맞은 Exception으로 변환
            throw new IllegalArgumentException(INTEGER_RANGE_EXCESS.getMessage());
        }
    }

    public static void checkNegative(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage()); // TODO: 알맞은 Exception으로 변환
        }
    }

    public static void checkMultiplesOfThousand(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(MULTIPLES_OF_THOUSAND.getMessage()); // TODO: 알맞은 Exception으로 변환
        }
    }

    public static void checkElementCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MAIN_NUMBERS_COUNT.getMessage());
        }
    }

    public static void checkWinningNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> checkWinningNumberRange(number));
    }

    public static void checkWinningNumberRange(int number) {
        if (number < RANGE_START || RANGE_END < number) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE.getMessage());
        }
    }

    public static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> singleNumbers = new HashSet<>(numbers);
        if (numbers.size() != singleNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXIST.getMessage());
        }
    }

    public static void checkBonusNumberDuplicate(List<Integer> mainNumber, int bonusNumber) {
        if (mainNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_EXIST.getMessage());
        }
    }
}
