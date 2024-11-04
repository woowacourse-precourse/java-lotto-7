package lotto.validation;

import static lotto.util.Constant.LOTTO_PRICE_UNIT;
import static lotto.util.Constant.MAX_PURCHASE_AMOUNT;

import java.util.List;
import lotto.util.MessageSource;

public class Validator {

    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.invalid_Amount_Unit"));
        }
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.exceeds_max_amount"));
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.invalid_winning_number_count"));
        }
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.invalid_number_range"));
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.invalid_number_range"));
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.duplicate_bonus_number"));
        }
    }
}
