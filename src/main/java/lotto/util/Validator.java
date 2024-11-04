package lotto.util;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoConstants.*;
import static lotto.constants.LottoErrorMessage.*;
import static lotto.constants.PurchaseAmountErrorMessage.BELOW_MINIMUM_AMOUNT;
import static lotto.constants.PurchaseAmountErrorMessage.NOT_DIVISIBLE_BY_MINIMUM;

public abstract class Validator {

    private static final int MINIMUM_AMOUNT = 1000;

    public static void validateTotalAmount(int purchaseAmount) {
        hasMinimum(purchaseAmount);
        isDivisibleByMinimumAmount(purchaseAmount);
    }

    public static void validateIntList(List<Integer> intList) {
        validateSize(intList);
        validateUniqueNumbers(intList);
        intList.forEach(Validator::validateInRange);
    }

    public static void validateNumber(int number, Lotto jackpotNumber) {
        validateInRange(number);
        if (jackpotNumber.getNumbers().contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER.getMessage());
        }
    }

    private static void hasMinimum(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(BELOW_MINIMUM_AMOUNT.getMessage());
        }
    }

    private static void isDivisibleByMinimumAmount(int purchaseAmount) {
        if (!(purchaseAmount % MINIMUM_AMOUNT == 0)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_MINIMUM.getMessage());
        }
    }

    private static void validateSize(List<Integer> intList) {
        if (intList.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private static void validateUniqueNumbers(List<Integer> intList) {
        Set<Integer> uniqueSet = new HashSet<>(intList);
        if (uniqueSet.size() != intList.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER.getMessage());
        }
    }

    private static void validateInRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
