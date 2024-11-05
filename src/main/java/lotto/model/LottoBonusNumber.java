package lotto.model;

import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoException;

import java.util.List;

public class LottoBonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new LottoException(LottoErrorMessage.NUMBER_OUT_OF_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(LottoErrorMessage.DUPLICATE_WINNING_NUMBERS);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}