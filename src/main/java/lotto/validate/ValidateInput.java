package lotto.validate;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.validate.LottoConstants.LOTTO_PRICE;
import static lotto.validate.LottoConstants.MIN_VALID_AMOUNT;
import static lotto.validate.LottoConstants.ZERO_VALID_AMOUNT;

public class ValidateInput {
    public static int validateAmount(String amountInput) {
        int amount = validateNumeric(amountInput);

        if (amount < MIN_VALID_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }

        if (amount % LOTTO_PRICE.getValue() != ZERO_VALID_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_UNIT_PRICE.getMessage());
        }

        return amount;
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBERS.getMessage());
        }

        winningNumbers.forEach(ValidateInput::validateNumberInRange);
    }

    public static int validateBonusNumber(String inputBonusNumber, Lotto winningLotto) {
        int bonusNumber = validateNumeric(inputBonusNumber);
        validateNumberInRange(bonusNumber);

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_DUPLICATE.getMessage());
        }

        return bonusNumber;
    }

    private static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER.getMessage());
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < LottoConstants.MIN_NUMBER.getValue() || number > LottoConstants.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }
    }
}
