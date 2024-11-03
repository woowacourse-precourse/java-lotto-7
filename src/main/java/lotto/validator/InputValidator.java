package lotto.validator;

import java.util.List;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class InputValidator {
    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt;
        try {
            purchaseAmountInt = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputException(LottoConstants.ERROR_NON_INTEGER_AMOUNT);
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt % 1000 != 0) {
            throw new InputException(LottoConstants.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
        }
        return purchaseAmountInt;
    }

    public static List<Integer> validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new InputException(LottoConstants.ERROR_INVALID_WINNING_NUMBER_COUNT);
        }
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new InputException(LottoConstants.ERROR_WINNING_NUMBER_OUT_OF_RANGE);
        }
        return winningNumbers;
    }

    public static int validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new InputException(LottoConstants.ERROR_BONUS_NUMBER_OUT_OF_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new InputException(LottoConstants.ERROR_DUPLICATE_BONUS_NUMBER);
        }
        return bonusNumber;
    }
}
