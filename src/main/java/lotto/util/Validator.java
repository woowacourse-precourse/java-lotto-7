package lotto.util;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoErrorMessage.DUPLICATE_INPUT_NUMBER;
import static lotto.constants.PurchaseAmountErrorMessage.BELOW_MINIMUM_AMOUNT;
import static lotto.constants.PurchaseAmountErrorMessage.NOT_DIVISIBLE_BY_MINIMUM;

public abstract class Validator {

    private static final int MINIMUM_AMOUNT = 1000;

    public static void validateTotalAmount(int purchaseAmount) {
        hasMinimum(purchaseAmount);
        isDivisibleByMinimumAmount(purchaseAmount);
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

    public static void validateIntList(List<Integer> jackpotList) {
        validateUniqueNumbers(jackpotList);
        Lotto lotto = new Lotto(jackpotList);
    }

    private static void validateUniqueNumbers(List<Integer> jackpotList) {
        Set<Integer> uniqueSet = new HashSet<>(jackpotList);
        if (uniqueSet.size() != jackpotList.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER.getMessage());
        }
    }
}
