package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.rule.LottoRule;
import lotto.message.Message;
import lotto.message.LottoErrorMessage;

public class Validator {

    private Validator() {
    }

    public static void checkAboveBaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoRule.PURCHASE_AMOUNT_UNIT.get()) {
            throw new IllegalArgumentException(LottoErrorMessage.PURCHASE_AMOUNT_UNDER_BASE_LIMIT.get());
        }
    }

    public static void checkPurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount % LottoRule.PURCHASE_AMOUNT_UNIT.get() != 0) {
            throw new IllegalArgumentException(LottoErrorMessage.PURCHASE_AMOUNT_UNIT_INVALID.get());
        }
    }

    public static void checkPurchaseQuantity(int quantity) {
        if (quantity < LottoRule.MIN_PURCHASE_QUANTITY.get()) {
            throw new IllegalArgumentException(LottoErrorMessage.MIN_QUANTITY_LOTTO_ISSUE.get());
        }
    }

    public static void checkLottoNumbersCount(List<Integer> numbers) {
        validateCount(numbers, LottoErrorMessage.LOTTO_NUMBERS_COUNT);
    }

    public static void checkLottoNumbersDuplicate(List<Integer> numbers) {
        validateDuplicate(numbers, LottoErrorMessage.LOTTO_NUMBERS_DUPLICATE);
    }

    public static void checkLottoNumbersRange(List<Integer> numbers) {
        validateRange(numbers, LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    public static void checkWinningNumbersCount(List<Integer> numbers) {
        validateCount(numbers, LottoErrorMessage.WINNING_NUMBERS_COUNT);
    }

    public static void checkWinningNumbersDuplicate(List<Integer> numbers) {
        validateDuplicate(numbers, LottoErrorMessage.WINNING_NUMBERS_DUPLICATE);
    }

    public static void checkWinningNumbersRange(List<Integer> numbers) {
        validateRange(numbers, LottoErrorMessage.WINNING_NUMBERS_OUT_OF_RANGE);
    }

    public static void checkBonusNumberRange(int number) {
        if (!LottoRule.isValidRange(number)) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.get());
        }
    }

    public static void checkWinningSetDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != LottoRule.LOTTO_NUMBERS_COUNT.get() + 1) {
            throw new IllegalArgumentException(LottoErrorMessage.WINNING_SET_NUMBERS_DUPLICATE.get());
        }
    }

    private static void validateCount(List<Integer> numbers, Message message) {
        if (numbers.size() != LottoRule.LOTTO_NUMBERS_COUNT.get()) {
            throw new IllegalArgumentException(message.get());
        }
    }

    private static void validateDuplicate(List<Integer> numbers, Message message) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(message.get());
        }
    }

    private static void validateRange(List<Integer> numbers, Message message) {
        long validNumbersCount = numbers.stream()
                .filter(LottoRule::isValidRange)
                .count();
        if (validNumbersCount != LottoRule.LOTTO_NUMBERS_COUNT.get()) {
            throw new IllegalArgumentException(message.get());
        }
    }
}
