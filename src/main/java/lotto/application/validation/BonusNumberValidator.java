package lotto.application.validation;
import lotto.util.ErrorMessages;

import java.util.List;

public class BonusNumberValidator implements BonusNumberValidation {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public Integer validate(String input) {
        int bonusNumber = parseNumber(input);
        validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    @Override
    public Integer validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = validate(input);
        validateNoOverlap(bonusNumber, winningNumbers);
        return bonusNumber;
    }
    @Override
    public int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_INPUT.getMessage());
        }
    }
    @Override
    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }
    @Override
    public void validateNoOverlap(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}