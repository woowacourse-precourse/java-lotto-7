package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.LottoConfig;

public class Validator {

    public static int validateNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorErrorMessage.NUMERIC_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateRange(int number) {
        if (number < LottoConfig.MIN_NUMBER || number > LottoConfig.MAX_NUMBER) {
            throw new IllegalArgumentException(ValidatorErrorMessage.RANGE_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_COUNT_NUMBER) {
            throw new IllegalArgumentException(ValidatorErrorMessage.NUMBER_COUNT_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorErrorMessage.BONUS_NUMERIC_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateCommaSeparated(String input) {
        if (!input.matches("^(\\d+)(,(\\d+))*$")) {
            throw new IllegalArgumentException(ValidatorErrorMessage.SEPARATER_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> testNumbers = new HashSet<>(numbers);
        if (testNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ValidatorErrorMessage.DUPLICATTE_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers, int bouns) {
        if (numbers.contains(bouns)) {
            throw new IllegalArgumentException(ValidatorErrorMessage.BONUS_DUPLICATTE_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateInteger(String input) {
        if (!input.matches("\\d+")) { // 정수인지 확인
            throw new IllegalArgumentException(ValidatorErrorMessage.NUMERIC_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateMoneyUnit(int money) {
        if (money % LottoConfig.MONEY_UNIT != LottoConfig.ZERO || money <= LottoConfig.ZERO) {
            throw new IllegalArgumentException(ValidatorErrorMessage.MONEY_UNIT_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateNumberList(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumber(numbers);
        for (int number : numbers) {
            validateRange(number);
        }
    }
}
