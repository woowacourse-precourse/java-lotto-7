package lotto.validation;

import lotto.error.ErrorStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int LOTTO_PRICE = 1000;

    public static void validateMoneyAmount(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
        }
    }

    public static void validateDuplicateNumbers(List<Integer> input) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : input) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorStatus.DUPLICATE_NUMBER.getMessage());
            }
        }
    }
}
