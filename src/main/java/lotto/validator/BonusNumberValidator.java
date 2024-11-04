package lotto.validator;

import static lotto.message.ErrorMessage.DUPLICATE_WINNING_NUMBERS_ERROR;
import static lotto.message.ErrorMessage.INVALID_NUMBER_ERROR;
import static lotto.message.ErrorMessage.PARSE_INT_ERROR;

import java.util.Set;
import lotto.domain.Lotto;

public class BonusNumberValidator {
    private int bonusNumber = 0;

    public boolean isNotValidBonusNumber(String userInput, Set<Integer> winningNumbers) {
        if (isNotParsableToBonusNumber(userInput)) {
            return true;
        }
        if (isInvalidNumber(bonusNumber)) {
            return true;
        }
        return isDuplicateWinnerNumbers(bonusNumber, winningNumbers);
    }

    private boolean isNotParsableToBonusNumber(String userInput) {
        try {
            bonusNumber = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(PARSE_INT_ERROR.getMessage());
            return true;
        }
        return false;
    }

    private boolean isInvalidNumber(int bonusNumber) {
        try {
            if (bonusNumber < Lotto.LOTTO_NUMBER_MIN || Lotto.LOTTO_NUMBER_MAX < bonusNumber) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER_ERROR.getMessage());
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
            System.out.println(DUPLICATE_WINNING_NUMBERS_ERROR.getMessage());
            return true;
        }
        return false;
    }

}
