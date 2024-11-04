package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumberRule;
import lotto.model.Lotto;

public class BonusNumberValidator implements Validator {
    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public BonusNumberValidator(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate() throws IllegalArgumentException {
        validateBonusNumberInRange();
        validateBonusNumberDuplication();
    }

    private void validateBonusNumberInRange() throws IllegalArgumentException {
        if (bonusNumber < LottoNumberRule.MIN_NUMBER.get() || bonusNumber > LottoNumberRule.MAX_NUMBER.get()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.get());
        }
    }

    private void validateBonusNumberDuplication() throws IllegalArgumentException {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.get());
        }
    }
}
