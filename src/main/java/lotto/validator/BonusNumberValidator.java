package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.GlobalConstant;

public class BonusNumberValidator {
    private String inputBonusNumber;

    private void setValue(String inputBonusNumber) {
        this.inputBonusNumber = inputBonusNumber;
    }

    public void validate(List<Integer> winningNumbers, String inputBonusNumber) {
        setValue(inputBonusNumber);
        validateBlank();
        validatePositiveInteger();
        validateDuplicateWithWinningNumbers(winningNumbers);
    }

    private void validateBlank() {
        if (inputBonusNumber.isEmpty() || inputBonusNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_BLANK_ERROR.toString());
        }
    }

    private void validatePositiveInteger() {
        if (!inputBonusNumber.trim().matches(GlobalConstant.NUMBER_REGEX.value())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NON_INTEGER_ERROR.toString());
        }
    }

    private void validateDuplicateWithWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(inputBonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.toString());
        }
    }
}
