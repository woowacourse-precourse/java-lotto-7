package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static int validateNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorErrorMessage.NUMERIC_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ValidatorErrorMessage.RANGE_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ValidatorErrorMessage.NUMBER_COUNT_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateCommaSeparated(String input) {
        if (!input.matches("^(\\d+)(,(\\d+))*$")) { // 숫자와 쉼표 패턴 검증
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
        if (money % 1000 != 0 || money <= 0) {
            throw new IllegalArgumentException(ValidatorErrorMessage.MONEY_UNIT_EXCEPTION.getErrorMessage());
        }
    }
}
