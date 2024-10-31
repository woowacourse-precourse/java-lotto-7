package lotto.validator;

import static lotto.message.ErrorMessage.DUPLICATE_WINNING_NUMBERS_ERROR;
import static lotto.message.ErrorMessage.INVALID_NUMBER_ERROR;
import static lotto.message.ErrorMessage.PARSE_INT_ERROR;

import java.util.Set;

public class BonusNumberValidator {
    private int bonusNumber = 0;

    public boolean isNotValidBonusNumber(String userInput, Set<Integer> winningNumbers) {
        if (isNotParsableToBonusNumber(userInput)) {
            return true;
        }
        if (isInvalidNumber(bonusNumber)) {
            return true;
        }
        if (isDuplicateWinnerNumbers(bonusNumber, winningNumbers)) {
            return true;
        }
        return false;
    }

    private boolean isNotParsableToBonusNumber(String userInput) {
        try {
            bonusNumber = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(PARSE_INT_ERROR.getMassage());
            return true;
        }
        return false;
    }

    private boolean isInvalidNumber(int bonusNumber) {
        try {
            if (bonusNumber < 1 || 45 < bonusNumber) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER_ERROR.getMassage());
            return true;
        }
        return false;
    }

    private boolean isDuplicateWinnerNumbers(int bonusNumber, Set<Integer> winningNumbers) {
        try {
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(DUPLICATE_WINNING_NUMBERS_ERROR.getMassage());
            return true;
        }
        return false;
    }

}
