package lotto.util;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ValidationUtil {
    public static void validateNumberCount(final List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateRange(final List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= LottoConstants.LOTTO_MIN_NUMBER.getValue() &&
                number <= LottoConstants.LOTTO_MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateNoDuplicates(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateBonusNumber(final int bonusNumber, final List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER.getValue() || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static int validateAmount(final String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        if (amount <= 0 || amount % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }

        return amount;
    }
}
