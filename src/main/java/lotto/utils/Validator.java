package lotto.utils;

import java.util.List;
import lotto.view.InputView;

public class Validator {

    public void validateInputPurchaseAmount(String inputPurchaseAmount) {
        if(!isValidNumber(inputPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
        if(Integer.parseInt(inputPurchaseAmount) < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_TOO_LOW.getMessage());
        }
        if (Integer.parseInt(inputPurchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE.getMessage());
        }
    }

    public void validateInputBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        if (!isValidNumber(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER_WITH_WINNING.getMessage());
        }
    }

    private boolean isValidNumber(String inputPurChaseAmount) {
        try {
            Integer.parseInt(inputPurChaseAmount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

