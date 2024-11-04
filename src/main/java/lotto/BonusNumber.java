package lotto;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoRange;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber == null || bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_RANGE.getText());
        }
        try {
            int number = Integer.parseInt(bonusNumber);
            if (LottoRange.MIN.getValue() > number || number > LottoRange.MAX.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.NUMBERS_RANGE.getText());
            } else if (isDuplicate(number, winningNumbers)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getText());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getText() + '"' + bonusNumber + '"');
        }
    }

    private boolean isDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}