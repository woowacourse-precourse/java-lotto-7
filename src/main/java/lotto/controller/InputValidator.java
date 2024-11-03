package lotto.controller;

import java.math.BigInteger;
import java.util.List;

import static lotto.NumbersGenerator.MAX;
import static lotto.NumbersGenerator.MIN;
import static lotto.domain.Lotto.NUMBER_COUNT;
import static lotto.exception.ExceptionCode.*;

public class InputValidator {

    public static final String SPLITTER = ",";

    public static void validateBudgetInput(String budgetInput) {
        try {
            new BigInteger(budgetInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        List<String> tokens = List.of(winningNumbers.split(SPLITTER));
        try {
            List<BigInteger> numbers = tokens.stream().map(String::strip).map(BigInteger::new).toList();
            validateWinningNumbersCount(numbers);
            validateWinningNumbersInRange(numbers);
            validateWinningNumbersDistinct(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

    private static void validateWinningNumbersCount(List<BigInteger> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNTS.message());
        }
    }

    private static void validateWinningNumbersDistinct(List<BigInteger> numbers) {
        if (numbers.stream().distinct().toList().size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
    }

    private static void validateWinningNumbersInRange(List<BigInteger> numbers) {
        numbers.stream().filter(number
                -> number.compareTo(BigInteger.valueOf(MIN)) < 0 || number.compareTo(BigInteger.valueOf(MAX)) > 0
        ).forEach(number -> {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        });
    }

    public static void validateBonusNumber(String numberInput, List<Integer> numbers) {
        try {
            int bonusNumber = Integer.parseInt(numberInput);
            if (numbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

}
