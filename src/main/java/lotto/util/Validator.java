package lotto.util;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static List<Integer> validateLottoNumbers(List<Integer> numbers) {
        validateUniqueNumbers(numbers);
        validateLottoRange(numbers);
        return numbers;
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoConstants.ERROR_DUPLICATE_NUMBER);
        }
    }

    private static void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LottoConstants.ERROR_LOTTO_RANGE);
            }
        }
    }
    public static int validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateLottoRange(bonusNumber);
        validateBonusNumberUniqueness(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateLottoRange(int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoConstants.ERROR_LOTTO_RANGE);
        }
    }

    private static void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_BONUS_DUPLICATE);
        }
    }

    public static int parseAndValidateAmount(int amount) {
        validateAmountRange(amount);
        validatePurchaseAmount(amount);
        return amount;
    }

    public static void validateNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_INVALID_INPUT);
        }
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    public static void validateAmount(int amount) {
        validateAmountRange(amount);
        validatePurchaseAmount(amount);
    }

    private static void validateAmountRange(int amount) {
        if (amount < LottoConstants.MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(LottoConstants.ERROR_INVALID_AMOUNT);
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % LottoConstants.MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(LottoConstants.ERROR_PURCHASE_AMOUNT);
        }
    }
}