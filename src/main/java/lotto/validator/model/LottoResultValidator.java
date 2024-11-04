package lotto.validator.model;

import lotto.entity.BonusNumber;
import lotto.entity.WinningNumber;
import lotto.enums.ExceptionMessage;
import lotto.validator.Validator;

import java.util.HashSet;

public class LottoResultValidator implements Validator {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public LottoResultValidator(WinningNumber winningNumbers, BonusNumber bonusNumber) {
        this.winningNumber = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate() {
        isDuplicated();
    }

    private void isDuplicated() {
        HashSet<Integer> numbers = new HashSet<>(winningNumber.getValue().getNumbers());
        numbers.add(bonusNumber.getValue());

        if (winningNumber.getValue().getNumbers().size() == numbers.size()) {
            printErrorMessageAndThrowError(ExceptionMessage.WINNING_BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}
