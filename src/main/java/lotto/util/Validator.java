package lotto.util;

import lotto.model.Lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.util.Constants.ZERO;
import static lotto.util.Constants.BLANK;
import static lotto.util.Constants.MIN_PURCHASE_MONEY;
import static lotto.util.Constants.NUMERIC_REGEX;
import static lotto.util.ErrorMessages.*;

public class Validator {

    public static void validateIsNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX))
            throw new IllegalArgumentException(NOT_NUMERIC);
    }

    public static void validateLottoRange(int number) {
        if (number < Constants.MIN_NUMBER || number > Constants.MAX_NUMBER)
            throw new IllegalArgumentException(OUT_OF_RANGE);
    }

    public static void validateIsDuplicate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER);
    }

    public static void validateNotBlank(String input) {
        if (input.contains(BLANK))
            throw new IllegalArgumentException(CONTAINS_WHITESPACE);
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size())
            throw new IllegalArgumentException(CONTAINS_DUPLICATES);
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
    }

    public static void validateIsDivisible(int input) {
        if (input % MIN_PURCHASE_MONEY != ZERO) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    public static void validateBelowMinimum(int input) {
        if (input < MIN_PURCHASE_MONEY) {
            throw new IllegalArgumentException(BELOW_MINIMUM_AMOUNT);
        }
    }
}
