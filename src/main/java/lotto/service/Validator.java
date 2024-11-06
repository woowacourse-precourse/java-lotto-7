package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.ErrorMessage;

public class Validator {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT.format(LOTTO_PRICE));
        }
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MIN_PURCHASE_AMOUNT.format(LOTTO_PRICE));
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT.format(LOTTO_NUMBERS_COUNT));
        }
        Set<Integer> numberSet = new HashSet<>(winningNumbers);
        if (numberSet.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
        for (int num : winningNumbers) {
            validateLottoNumberRange(num);
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateLottoNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateLottoNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(
                ErrorMessage.NUMBER_RANGE.format(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
        }
    }
}
